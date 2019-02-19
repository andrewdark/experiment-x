package ua.pp.darknsoft.services.errors;

import org.springframework.http.HttpStatus;
import ua.pp.darknsoft.errors.ErrorCode;

public enum UserServiceErrorCodes implements ErrorCode {
    USERNAME_EXISTS ("Bad credentials.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final HttpStatus httpStatus;

    UserServiceErrorCodes(String code, HttpStatus httpStatus) {
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

