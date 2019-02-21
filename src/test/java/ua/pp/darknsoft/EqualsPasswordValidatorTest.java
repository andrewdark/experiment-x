package ua.pp.darknsoft;

import org.junit.Before;
import org.junit.Test;
import ua.pp.darknsoft.payload.SignupRequest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

public class EqualsPasswordValidatorTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


    @Test
    public void test_passwordsNonEqual_marksDataInvalid() {
        SignupRequest request = new SignupRequest("username", "pa$$W0rd", "pass");

        Set<ConstraintViolation<SignupRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size());
        assertThat(violations.toString(), containsString("Password and Confirmed Password should be equal"));
    }

}
