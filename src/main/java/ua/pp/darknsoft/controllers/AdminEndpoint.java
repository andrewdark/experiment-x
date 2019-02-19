package ua.pp.darknsoft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminEndpoint {
    @PostMapping()
    public ResponseEntity<?>board() {
        return ResponseEntity.ok("Admin board should be here");
    }

}
