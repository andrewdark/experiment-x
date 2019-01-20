package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pp.darknsoft.models.User;
import ua.pp.darknsoft.services.authentication.UserAuthenticationService;

@RestController
@RequestMapping("/")
public final class SecuredUsersController {

    @Autowired
    UserAuthenticationService authenticationService;

    @GetMapping("/profile")
    User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final User user) {
        authenticationService.logout(user);
        return true;
    }
}