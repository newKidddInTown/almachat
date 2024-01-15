package com.example.almachat.registration.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@Builder
public class User {

    private String id;
    private String username;
    private String password;
    private String displayName;
    private boolean allowOtherSearchMeByPhone;
    private boolean allowOtherSearchMeByEmail;
    @Builder.Default
    private List<Authority> authorities = new ArrayList<>();
}
