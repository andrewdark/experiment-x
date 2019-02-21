package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.dto.SignupDto;
import ua.pp.darknsoft.models.User;

@Component
public class UserToSignupDto implements Converter<User, SignupDto> {

    private final Object $lock = new Object();

    @Nullable
    @Override
    public SignupDto convert(User user) {
        synchronized ($lock) {
            if (user == null) {
                return null;
            }
            final SignupDto signupDto = new SignupDto();
            signupDto.setId(user.getId());
            signupDto.setUsername(user.getUsername());
            signupDto.setPassword(user.getPassword());
            return signupDto;
        }
    }
}