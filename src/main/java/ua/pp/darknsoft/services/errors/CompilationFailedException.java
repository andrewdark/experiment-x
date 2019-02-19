package ua.pp.darknsoft.services.errors;

import ua.pp.darknsoft.errors.ExperimentXException;

public class CompilationFailedException extends ExperimentXException {
    public CompilationFailedException(String errorMessage) {
        super(errorMessage);
    }
}

