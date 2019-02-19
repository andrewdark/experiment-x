package ua.pp.darknsoft.services.errors;

import org.springframework.stereotype.Component;
import ua.pp.darknsoft.errors.ErrorCode;
import ua.pp.darknsoft.errors.ExceptionToErrorCode;


public class UserServiceExceptionMappers {
    @Component
    static class UsernameExistsExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof UsernameExistsException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return UserServiceErrorCodes.USERNAME_EXISTS;
        }
    }
}

