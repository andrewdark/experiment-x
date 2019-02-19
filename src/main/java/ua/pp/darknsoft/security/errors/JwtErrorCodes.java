package ua.pp.darknsoft.security.errors;

import org.springframework.http.HttpStatus;
import ua.pp.darknsoft.errors.ErrorCode;

public enum JwtErrorCodes implements ErrorCode {
    JWT_EXPIRED("JWT expired.", HttpStatus.UNAUTHORIZED),
    JWT_VALIDATION_FAILURE("JWT validation failed.", HttpStatus.UNAUTHORIZED);

    private final String code;
    private final HttpStatus httpStatus;

    JwtErrorCodes(String code, HttpStatus httpStatus) {
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
