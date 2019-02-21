package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.dto.SignupDto;
import ua.pp.darknsoft.models.User;

@Component
public class SignupDtoToUser implements Converter<SignupDto, User> {

    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public User convert(SignupDto signupDto) {

        synchronized ($lock) {
            if (signupDto == null) {
                return null;
            }
            final User user = new User();
            user.setId(signupDto.getId());
            user.setUsername(signupDto.getUsername());
            user.setPassword(signupDto.getPassword());
            return user;
        }

    }
}
