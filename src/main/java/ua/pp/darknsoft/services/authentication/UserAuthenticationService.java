package ua.pp.darknsoft.services.authentication;

import ua.pp.darknsoft.models.User;

import java.util.Optional;

public interface UserAuthenticationService {
    Optional<String> login(String username, String password);
    Optional<User> findByToken(String token);
    void logout(User user);
}