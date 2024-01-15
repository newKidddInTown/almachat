package com.example.almachat.registration.repository;

import com.example.almachat.registration.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNo(String email);
}
