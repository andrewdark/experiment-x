package ua.pp.darknsoft.services.authentication;

import com.google.common.collect.ImmutableMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.services.user.UserCrudService;
import ua.pp.darknsoft.services.token.TokenService;

import java.util.Objects;
import java.util.Optional;

@Service
public final class TokenAuthenticationService implements UserAuthenticationService {
    @Autowired
    TokenService tokens;

    @Autowired
    UserCrudService users;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<String> login(final String username, final String password) {
        return users
                .findByUsername(username)
                .filter(user-> bCryptPasswordEncoder.matches(password, user.getPassword()))
                .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return Optional
                .of(tokens.verify(token))
                .map(map -> map.get("username"))
                .flatMap(users::findByUsername);
    }

    @Override
    public void logout(final User user) {

    }
}
