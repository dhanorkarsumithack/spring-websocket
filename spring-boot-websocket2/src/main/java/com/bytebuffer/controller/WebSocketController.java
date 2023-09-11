package com.bytebuffer.controller;

import com.bytebuffer.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @MessageMapping("/send-message")
    @SendTo("/topic/prime")
    public Message sendMessage(Message message) {
        return message;
    }

    @MessageMapping("/receive-message")
    @SendTo("/topic/prime")
    public Message receiveMessge(){


        return Message.builder()
                .messageType("casual")
                .data("this is my name")
                .build();
    }
}
