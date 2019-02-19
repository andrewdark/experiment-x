package ua.pp.darknsoft.errors;

import com.google.common.base.Preconditions;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.pp.darknsoft.services.errors.UsernameExistsException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String NO_MESSAGE_AVAILABLE = "No message available";

    private final ErrorCodes errorCodes;

    private final MessageSource apiErrorMessageSource;

    GlobalExceptionHandler(ErrorCodes errorCodes, MessageSource apiErrorMessageSource) {
        this.errorCodes =
                Preconditions.checkNotNull(errorCodes,"ExceptionHandler instance cannot be constructed, ErrorCodes parameter is null");
        this.apiErrorMessageSource =
                Preconditions.checkNotNull(apiErrorMessageSource,"ExceptionHandler instance cannot be constructed, ApiMessageSourse parameter is null");
    }

    @ExceptionHandler(ExperimentXException.class)
    ResponseEntity<ErrorResponse> handleServiceException(ExperimentXException exception) {
        ErrorCode errorCode = errorCodes.of(exception);
        ErrorResponse errorResponse = ErrorResponse.of(errorCode.httpStatus(), new ErrorResponse.ApiError(errorCode.code(), exception.getMessage()));
        return ResponseEntity.status(errorCode.httpStatus()).body(errorResponse);
    }

    //this will handle our validation form, e.g. register request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception, Locale locale) {
        Stream<ObjectError> errors = exception.getBindingResult().getAllErrors().stream();
        List<ErrorResponse.ApiError> apiErrors = errors
                .map(ObjectError::getDefaultMessage)
                .map(this::validationErrorCode)
                .map(code -> toApiError(code, locale))
                .collect(toList());

        return ResponseEntity.badRequest().body(ErrorResponse.ofErrors(HttpStatus.BAD_REQUEST, apiErrors));
    }

    private ErrorResponse.ApiError toApiError(ErrorCode errorCode, Locale locale) {
        String message;
        try {
            message = apiErrorMessageSource.getMessage(errorCode.code(), new Object[]{}, locale);
        } catch (NoSuchMessageException e) {
            message = NO_MESSAGE_AVAILABLE;
        }

        return new ErrorResponse.ApiError(errorCode.code(), message);
    }

    private ErrorCode validationErrorCode(final String errorCode) {
        return new ErrorCode() {
            @Override
            public String code() {
                return errorCode;
            }

            @Override
            public HttpStatus httpStatus() {
                return HttpStatus.BAD_REQUEST;
            }
        };
    }
}
