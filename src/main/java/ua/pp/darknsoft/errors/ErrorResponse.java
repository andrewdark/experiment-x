package ua.pp.darknsoft.errors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class ErrorResponse {
    private final int statusCode;

    private final String reason;

    private final List<ApiError> errors;

    private ErrorResponse(int statusCode, String reason, List<ApiError> errors) {
        Preconditions.checkArgument(statusCode >= 400 && statusCode < 600,
                "Error Status codes should be between 400 and 600");

        Preconditions.checkArgument(reason !=  null && !reason.trim().isEmpty(),
                "HTTP Response reason phrase can not be null or empty");

        Preconditions.checkArgument(errors != null && !errors.isEmpty(),
                "Errors list can't be null or empty");

        this.statusCode = statusCode;
        this.reason = reason;
        this.errors = errors;
    }

    static ErrorResponse ofErrors(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), status.getReasonPhrase(), errors);
    }

    public static ErrorResponse of(HttpStatus status, ApiError error) {
        return ofErrors(status, Collections.singletonList(error));
    }


    @JsonAutoDetect(fieldVisibility = ANY)
    public static class ApiError {
        private final String code;
        private final String message;

        public ApiError(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}
