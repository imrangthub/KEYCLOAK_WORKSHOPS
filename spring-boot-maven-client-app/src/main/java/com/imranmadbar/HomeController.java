package com.imranmadbar;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> hello(Authentication authentication) {
        final String body = "Hello From Home: " + authentication.getName();
        return ResponseEntity.ok(body);
    }
}
