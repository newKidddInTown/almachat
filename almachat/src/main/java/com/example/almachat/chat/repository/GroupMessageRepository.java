package com.example.almachat.chat.repository;

import com.example.almachat.chat.domain.GroupMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageRepository extends MongoRepository<GroupMessage, String> {
}
