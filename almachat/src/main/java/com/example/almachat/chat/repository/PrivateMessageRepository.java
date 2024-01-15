package com.example.almachat.chat.repository;

import com.example.almachat.chat.domain.PrivateMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateMessageRepository extends MongoRepository<PrivateMessage, String> {
}
