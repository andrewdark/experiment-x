package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.models.Profile;

@Component
public class ProfileTOToProfile implements Converter<ProfileTO, Profile> {

    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public Profile convert(ProfileTO profileTO) {
        synchronized ($lock) {
            if (profileTO == null) {
                return null;
            }
            final Profile profile = new Profile();
            profile.setFirstName(profileTO.getFirstName());
            profile.setLastName(profileTO.getLastName());
            profile.setEmail(profileTO.getLastName());
            return profile;
        }

    }
}
