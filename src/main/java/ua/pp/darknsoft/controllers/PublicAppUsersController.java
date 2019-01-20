package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.services.user.UserCrudService;
import ua.pp.darknsoft.services.authentication.UserAuthenticationService;

@RestController
@RequestMapping("/auth")
public final class PublicAppUsersController {
    @Autowired
    UserAuthenticationService authentication;

    @Autowired
    UserCrudService users;

    @PostMapping("/register")
    String register(@RequestParam("username") final String username,
                    @RequestParam("password") final String password) {

        users.create(username, password);
        return login(username, password);
    }

    @PostMapping("/login")
    String login(@RequestParam("username") final String username,
                 @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}
