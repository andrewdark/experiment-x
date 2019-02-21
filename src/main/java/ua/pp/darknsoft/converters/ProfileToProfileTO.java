package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.models.Profile;

@Component
public class ProfileToProfileTO implements Converter<Profile, ProfileTO> {

    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public ProfileTO convert(Profile profile) {
        synchronized ($lock) {
            if (profile == null) {
                return null;
            }
            final ProfileTO profileTO = new ProfileTO();
            profileTO.setFirstName(profile.getFirstName());
            profileTO.setLastName(profile.getLastName());
            profileTO.setEmail(profile.getEmail());
            return profileTO;
        }
    }
}
