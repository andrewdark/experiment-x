package ua.pp.darknsoft.errors;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ErrorCodes {
    private final ApplicationContext context;

    ErrorCodes(ApplicationContext context) {
        this.context = context;
    }

    public ErrorCode of(Exception exception) {
        return implementations()
                .filter(impl -> impl.canHandle(exception))
                .findFirst()
                .map(impl -> impl.toErrorCode(exception))
                .orElse(ErrorCode.Uncharted.INSTANCE);
    }

    private Stream<ExceptionToErrorCode> implementations() {
        return context.getBeansOfType(ExceptionToErrorCode.class).values().stream();
    }
}
