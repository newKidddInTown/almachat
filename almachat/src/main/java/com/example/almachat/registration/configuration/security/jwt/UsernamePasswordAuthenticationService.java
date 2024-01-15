package com.example.almachat.registration.configuration.security.jwt;

import com.example.almachat.registration.dto.LoginRequest;
import com.example.almachat.registration.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsernamePasswordAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public String authenticate(LoginRequest request) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails user = (UserDetails) authenticate.getPrincipal();
            return jwtTokenUtil.generateAccessToken(user);
        } catch (BadCredentialsException ex) {
            throw CustomException.Builder
                    .newBuilder()
                    .code("BAD_CREDENTIALS")
                    .message("The username and password is not correct!")
                    .build();
        }
    }
}
