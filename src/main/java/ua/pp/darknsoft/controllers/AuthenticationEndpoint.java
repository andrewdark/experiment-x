package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.payload.SigninRequest;
import ua.pp.darknsoft.payload.SignupRequest;
import ua.pp.darknsoft.security.model.Jwt;
import ua.pp.darknsoft.security.service.AuthenticationService;
import ua.pp.darknsoft.services.user.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/auth", consumes="application/json", produces="application/json")

public class AuthenticationEndpoint {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;


    @PostMapping("/signin")
    public ResponseEntity<Jwt> authenticate(@Valid @RequestBody SigninRequest request) {
        return ResponseEntity.ok().body(authenticationService.authenticateUser(request.getUsername(), request.getPassword()));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<String> register(@Valid @RequestBody SignupRequest request) {
        userService.createUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok().body("User signed up successfully");
    }
}