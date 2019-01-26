package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.models.AppUser;
import ua.pp.darknsoft.services.AppUserService;

@Controller
public class MainController {

    @Autowired
    AppUserService appUserService;

    @PostMapping(value = "/dashboard", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AppUser> dashboard(@AuthenticationPrincipal AppUser user) {
            return new ResponseEntity<AppUser>(user, HttpStatus.OK);
    }

    /*@PostMapping(value = "/login")
    public ResponseEntity<Void> login(Authentication authentication) {
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PostMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestParam String username, @RequestParam String password, Authentication authentication) {
        if (appUserService.isExists(username)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        appUserService.createAppUser(username, password);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //HttpHeaders headers = new HttpHeaders();
        //headers.add("Location", "/login");
        //return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @PostMapping(value = "/logout")
    public ResponseEntity<Void> logout() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
