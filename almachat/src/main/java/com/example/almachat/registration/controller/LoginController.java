package com.example.almachat.registration.controller;

import com.example.almachat.registration.dto.LoginRequest;
import com.example.almachat.registration.configuration.security.OAuth2AuthenticationService;
import com.example.almachat.registration.configuration.security.jwt.UsernamePasswordAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login/v1")
@RequiredArgsConstructor
public class LoginController {

    private final UsernamePasswordAuthenticationService usernamePasswordAuth;
    private final OAuth2AuthenticationService oAuth2AuthenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<Void> authenticate(@RequestBody LoginRequest request) {
        final String token = usernamePasswordAuth.authenticate(request);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .build();
    }

    // login via gitHub

    // login via google

    // reset password

}
