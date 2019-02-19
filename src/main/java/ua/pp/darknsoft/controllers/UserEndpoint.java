package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pp.darknsoft.dto.ProfileTO;
import ua.pp.darknsoft.security.service.AuthenticationService;
import ua.pp.darknsoft.services.profile.ProfileService;


@RestController
@RequestMapping(value="/user", consumes="application/json", produces="application/json")
public class UserEndpoint {
    @Autowired
    ProfileService profileService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/dashboard")
    public ResponseEntity<String> dashboard() {
        Long userId = authenticationService.getAuthenticatedUserId();
        //
        return ResponseEntity.ok().body("Dashboard info should be placed");
    }

    @PostMapping("/profile")
    @ResponseBody
    public ResponseEntity<ProfileTO> getProfile() {
        Long userId = authenticationService.getAuthenticatedUserId();
        return ResponseEntity.ok().body(profileService.getProfile(userId));
    }


    @PutMapping("/profile")
    @ResponseBody
    public ResponseEntity<String> updateProfile(@RequestBody ProfileTO profileTO) {
        Long userId = authenticationService.getAuthenticatedUserId();
        profileService.updateProfile(userId, profileTO);
        return ResponseEntity.ok().body("Profile updated successfully");
    }

}

