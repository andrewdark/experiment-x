package ua.pp.darknsoft.errors;

public interface ExceptionToErrorCode {
    boolean canHandle(Exception exception);
    ErrorCode toErrorCode(Exception exception);
}
