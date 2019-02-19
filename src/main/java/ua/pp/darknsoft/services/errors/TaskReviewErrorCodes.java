package ua.pp.darknsoft.services.errors;

import org.springframework.http.HttpStatus;
import ua.pp.darknsoft.errors.ErrorCode;

public enum TaskReviewErrorCodes implements ErrorCode {
    COMPILATION_FAILED ("Compilation failed.", HttpStatus.BAD_REQUEST),
    TESTS_NOT_PASSED("Tests not passed.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final HttpStatus httpStatus;

    TaskReviewErrorCodes(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }
}
