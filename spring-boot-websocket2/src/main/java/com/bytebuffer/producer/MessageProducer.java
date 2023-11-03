package com.bytebuffer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class MessageProducer {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void produce(){
        Random random = new Random();
            Map<String, Object> jsonMessage = new HashMap<>();
            jsonMessage.put("messageType", "sample");
            jsonMessage.put("data", "Sample JSON Data 1");
            jsonMessage.put("randomNumber", random.nextInt(100));
            simpMessagingTemplate.convertAndSend("/topic", jsonMessage);
    }
}
