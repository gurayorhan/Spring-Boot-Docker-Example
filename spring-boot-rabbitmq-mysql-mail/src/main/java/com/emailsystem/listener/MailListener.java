package com.emailsystem.listener;

import com.emailsystem.dto.MailDto;
import com.emailsystem.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailListener {

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "mail-queue")
    public void handleMessage(MailDto mailDto){
        try {
            System.out.println("E-mail information is correct. Registration Successful.");
            mailService.add(mailDto);
        }catch (Exception e){
            System.out.println("E-mail information is wrong. Registration failed.");
        }
    }

}
