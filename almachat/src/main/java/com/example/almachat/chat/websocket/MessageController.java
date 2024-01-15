package com.example.almachat.chat.websocket;

import com.example.almachat.chat.domain.GroupMessage;
import com.example.almachat.chat.domain.PrivateMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController  {

    private final SimpMessageSendingOperations operations;
    @MessageMapping("/send_private_message")
    public void sendMessage(PrivateMessage message) {
        operations.convertAndSendToUser(message.getReceiver(), "receiver", message);
    }
    @MessageMapping("/send_group_message")
    public void sendMessage(GroupMessage message) {
        operations.convertAndSendToUser(message.getGroupId(), "group", message);
    }
}
