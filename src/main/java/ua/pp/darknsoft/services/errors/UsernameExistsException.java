package ua.pp.darknsoft.services.errors;

import ua.pp.darknsoft.errors.ExperimentXException;

public class UsernameExistsException extends ExperimentXException {
    public UsernameExistsException(String errorMessage) {
        super(errorMessage);
    }
}

