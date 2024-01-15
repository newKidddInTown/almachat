package com.example.almachat.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String id;
    private String sender;
    private Date when;
    private String content;
}
