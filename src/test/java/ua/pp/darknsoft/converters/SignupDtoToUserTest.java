package ua.pp.darknsoft.converters;

import org.junit.Before;
import org.junit.Test;
import ua.pp.darknsoft.dto.SignupDto;
import ua.pp.darknsoft.models.User;

import static org.junit.Assert.*;

public class SignupDtoToUserTest {

    public static final Long ID_VALUE = Long.valueOf(1L);
    public static final String USER_NAME = "Pinokio";
    public static final String PASSWD = "MyPwd777";
    SignupDtoToUser converter;

    @Before
    public void setUp() throws Exception {
        converter = new SignupDtoToUser();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new SignupDto()));
    }

    @Test
    public void convert() throws Exception {
        //given
        SignupDto signupDto = new SignupDto();
        signupDto.setId(ID_VALUE);
        signupDto.setUsername(USER_NAME);
        signupDto.setPassword(PASSWD);

        //when
        User user = converter.convert(signupDto);

        //then
        assertNotNull(user);
        assertEquals(ID_VALUE, user.getId());
        assertEquals(USER_NAME, user.getUsername());
        assertEquals(PASSWD, user.getPassword());
    }
}
