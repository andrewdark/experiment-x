package ua.pp.darknsoft.security.service;

import ua.pp.darknsoft.security.model.Jwt;

public interface AuthenticationService {
    Jwt authenticateUser(String username, String password);
    Long getAuthenticatedUserId();
}
