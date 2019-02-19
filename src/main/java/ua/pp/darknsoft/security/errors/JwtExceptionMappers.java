package ua.pp.darknsoft.security.errors;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.errors.ErrorCode;
import ua.pp.darknsoft.errors.ExceptionToErrorCode;

public class JwtExceptionMappers {
    @Component
    static class ExpiredJwtExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof ExpiredJwtException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return JwtErrorCodes.JWT_EXPIRED;
        }
    }

    @Component
    static class SignatureExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof SignatureException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return JwtErrorCodes.JWT_VALIDATION_FAILURE;
        }
    }

    @Component
    static class MalformedJwtExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof MalformedJwtException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return JwtErrorCodes.JWT_VALIDATION_FAILURE;
        }
    }

    @Component
    static class UnsupportedJwtExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof UnsupportedJwtException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return JwtErrorCodes.JWT_VALIDATION_FAILURE;
        }
    }

    @Component
    static class IllegalArgumentExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof IllegalArgumentException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return JwtErrorCodes.JWT_VALIDATION_FAILURE;
        }
    }
}
