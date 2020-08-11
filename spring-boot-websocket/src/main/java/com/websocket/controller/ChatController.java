package com.websocket.controller;

import com.websocket.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin // cross platformdan etkilenmemek için
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    // @SendTo --> herkese hangi kanala
    // @SendToUser --> kanal ve bir usera gönderir
    // @SendTo("/topic")
    public void sendMessage(@Payload Message message){
        System.out.println(message.getSender()+"-"+message.getMessage());
        messagingTemplate.convertAndSend("/topic", message); // SendTo ya denk gelmektedir.
    }

}
