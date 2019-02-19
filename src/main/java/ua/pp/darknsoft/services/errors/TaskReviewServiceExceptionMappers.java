package ua.pp.darknsoft.services.errors;

import org.springframework.stereotype.Component;
import ua.pp.darknsoft.errors.ErrorCode;
import ua.pp.darknsoft.errors.ExceptionToErrorCode;

public class TaskReviewServiceExceptionMappers {
    @Component
    static class CompilationFailedExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof CompilationFailedException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return TaskReviewErrorCodes.COMPILATION_FAILED;
        }
    }

    @Component
    static class TestsNotPassedExceptionToErrorCode implements ExceptionToErrorCode {
        @Override
        public boolean canHandle(Exception exception) {
            return exception instanceof TestsNotPassedException;
        }

        @Override
        public ErrorCode toErrorCode(Exception exception) {
            return TaskReviewErrorCodes.TESTS_NOT_PASSED;
        }
    }
}
