package com.rabbitmq.controller;

import com.rabbitmq.model.Notification;
import com.rabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.UUID;

@Controller
public class RabbitMQController {

    @Autowired
    private NotificationProducer notificationProducer;

    @PostMapping("/Send")
    public ResponseEntity<Boolean> send(@RequestBody Notification notification){
        notification.setCreatedAt(new Date());
        notification.setId(UUID.randomUUID().toString());
        notification.setSeen(Boolean.FALSE);
        notificationProducer.sendToQueue(notification);
        return ResponseEntity.ok(true);
    }

}
