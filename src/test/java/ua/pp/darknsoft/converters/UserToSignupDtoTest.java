package ua.pp.darknsoft.converters;

import org.junit.Before;
import org.junit.Test;
import ua.pp.darknsoft.dto.SignupDto;
import ua.pp.darknsoft.models.User;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserToSignupDtoTest {
    public static final Long ID_VALUE = Long.valueOf(1L);
    public static final String USER_NAME = "Pinokio";
    public static final String PASSWD = "MyPwd777";

    UserToSignupDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new UserToSignupDto();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new User()));
    }

    @Test
    public void convert() throws Exception {
        //given
        User user = new User();
        user.setId(ID_VALUE);
        user.setUsername(USER_NAME);
        user.setPassword(PASSWD);

        //when
        SignupDto signupDto = converter.convert(user);

        //then
        assertNotNull(signupDto);
        assertEquals(ID_VALUE, signupDto.getId());
        assertEquals(USER_NAME, signupDto.getUsername());
        assertEquals(PASSWD, signupDto.getPassword());
    }
}
