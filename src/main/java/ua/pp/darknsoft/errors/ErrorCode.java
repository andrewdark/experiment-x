package ua.pp.darknsoft.errors;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String UNCHARTED_ERROR = "uncharted";

    String code();
    HttpStatus httpStatus();

    enum Uncharted implements ErrorCode {
        INSTANCE;

        public String code() {
            return UNCHARTED_ERROR;
        }

        public HttpStatus httpStatus() {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
