package com.example.almachat.registration.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegisterRequest {

    @Email
    private String email;
    private String phoneNumber;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
