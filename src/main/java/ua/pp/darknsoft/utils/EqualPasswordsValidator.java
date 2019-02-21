package ua.pp.darknsoft.utils;

import ua.pp.darknsoft.payload.SignupRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, SignupRequest> {
    @Override
    public void initialize(EqualPasswords constraint) {
    }

    @Override
    public boolean isValid(SignupRequest request, ConstraintValidatorContext context) {
        return request.getPassword().equals(request.getConfirmedPassword());
    }

}

