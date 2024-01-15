package com.example.almachat.registration.service;

import com.example.almachat.registration.domain.Profile;
import com.example.almachat.registration.domain.User;
import com.example.almachat.registration.dto.RegisterRequest;
import com.example.almachat.registration.exception.CustomException;
import com.example.almachat.registration.repository.ProfileRepository;
import com.example.almachat.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {

        // validate before register
        boolean emailBlank = StringUtils.isBlank(request.getEmail());
        boolean phoneBlank = StringUtils.isBlank(request.getPhoneNumber());

        if (emailBlank && phoneBlank) {
            throw CustomException.Builder
                    .newBuilder()
                    .code("MISSING_REGISTER_INFO")
                    .message("Email or phone is missing")
                    .build();
        }

        if (!emailBlank && profileRepository.existsByEmail(request.getEmail())) {
            throw CustomException.Builder
                    .newBuilder()
                    .code("MAIL_REGISTERED")
                    .message("Email is registered already")
                    .build();
        }

        if (!emailBlank && profileRepository.existsByPhoneNo(request.getEmail())) {
            throw CustomException.Builder
                    .newBuilder()
                    .code("MAIL_REGISTERED")
                    .message("Email is registered already")
                    .build();
        }

        // save user info
        final User user = userRepository.save(User
                .builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());

        // save profile info
        profileRepository.save(Profile
                .builder()
                .userId(user.getId())
                .email(request.getEmail())
                .phoneNo(request.getPhoneNumber())
                .build());

    }
}
