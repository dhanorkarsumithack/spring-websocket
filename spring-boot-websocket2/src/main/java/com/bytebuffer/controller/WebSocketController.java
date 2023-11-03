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
        System.out.println("send message "+message);
        return message;
    }

    @MessageMapping("/receive-message")
    @SendTo("/topic/prime")
    public Message receiveMessge(){

        System.out.println("receive message");

        return Message.builder()
                .messageType("casual")
                .data("this is my name")
                .build();
    }
}
