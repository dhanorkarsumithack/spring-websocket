package com.websocket.chat;

import lombok.*;

import java.net.Proxy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String content;

    private String sender;

    private  MessageType type;


}
