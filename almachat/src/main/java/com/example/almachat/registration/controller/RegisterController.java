package com.example.almachat.registration.controller;

import com.example.almachat.registration.dto.RegisterRequest;
import com.example.almachat.registration.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/regis/v1")
public class RegisterController {

    private final RegisterService registerService;
    @PostMapping("/account")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        registerService.register(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
