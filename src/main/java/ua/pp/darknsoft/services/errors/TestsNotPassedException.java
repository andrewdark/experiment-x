package ua.pp.darknsoft.services.errors;

import ua.pp.darknsoft.errors.ExperimentXException;

public class TestsNotPassedException extends ExperimentXException {
    public TestsNotPassedException(String errorMessage) {
        super(errorMessage);
    }
}
