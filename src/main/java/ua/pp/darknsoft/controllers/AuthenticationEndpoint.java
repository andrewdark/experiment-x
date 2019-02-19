package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.pp.darknsoft.security.model.Jwt;
import ua.pp.darknsoft.security.service.AuthenticationService;
import ua.pp.darknsoft.services.user.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationEndpoint {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;


    @PostMapping("/signin")
    public ResponseEntity<Jwt> authenticate(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok().body(authenticationService.authenticateUser(username, password));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return ResponseEntity.ok().body("User signed up successfully");
    }
}