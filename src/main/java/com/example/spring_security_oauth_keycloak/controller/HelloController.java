package com.example.spring_security_oauth_keycloak.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hello world " + authentication.getName();
    }

}
