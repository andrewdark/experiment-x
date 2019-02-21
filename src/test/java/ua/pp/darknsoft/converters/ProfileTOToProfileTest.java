package ua.pp.darknsoft.converters;

import org.junit.Before;
import org.junit.Test;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.models.Profile;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProfileTOToProfileTest {

    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Thompson";
    public static final String EMAIL = "jt@mail.com";

    ProfileTOToProfile converter;

    @Before
    public void setUp() throws Exception {
        converter = new ProfileTOToProfile();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ProfileTO()));
    }

    @Test
    public void convert() throws Exception {
        ProfileTO profileTO = new ProfileTO();
        profileTO.setFirstName(FIRST_NAME);
        profileTO.setLastName(LAST_NAME);
        profileTO.setEmail(EMAIL);

        Profile profile = converter.convert(profileTO);

        assertNotNull(profile);
        assertEquals(FIRST_NAME, profile.getFirstName());
        assertEquals(LAST_NAME, profile.getLastName());
        assertNotNull(EMAIL, profile.getEmail());

    }
}
