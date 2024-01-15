package com.example.almachat.chat.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "groups")
@Data
public class Group {

    private String id;
    private String name;
    private List<String> members;
}
