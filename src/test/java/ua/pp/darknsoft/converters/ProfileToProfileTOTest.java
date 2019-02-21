package ua.pp.darknsoft.converters;

import org.junit.Before;
import org.junit.Test;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.models.Profile;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProfileToProfileTOTest {

    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Thompson";
    public static final String EMAIL = "jt@mail.com";

    ProfileToProfileTO converter;

    @Before
    public void setUp() throws Exception {
        converter = new ProfileToProfileTO();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Profile()));
    }

    @Test
    public void convert() throws Exception {
        Profile profile = new Profile();
        profile.setFirstName(FIRST_NAME);
        profile.setLastName(LAST_NAME);
        profile.setEmail(EMAIL);

        ProfileTO profileTO = converter.convert(profile);

        assertNotNull(profile);
        assertEquals(FIRST_NAME, profileTO.getFirstName());
        assertEquals(LAST_NAME, profileTO.getLastName());
        assertNotNull(EMAIL, profileTO.getEmail());


    }
}
