package com.example.almachat.registration.repository;

import com.example.almachat.registration.domain.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String s);
}
