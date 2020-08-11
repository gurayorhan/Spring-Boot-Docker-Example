package com.rabbitmq.listener;

import com.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "learn-queue")
    public void handleMessage(Notification notification){
        System.out.println(notification.getMessage());
    }

}
