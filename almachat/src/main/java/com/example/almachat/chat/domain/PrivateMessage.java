package com.example.almachat.chat.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@SuperBuilder
@Data
@Document(collection = "private_messages")
public class PrivateMessage extends Message{

    private String receiver;
    private boolean isRead;
}
