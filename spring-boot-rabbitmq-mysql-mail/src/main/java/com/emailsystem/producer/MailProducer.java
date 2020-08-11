package com.emailsystem.producer;

import com.emailsystem.dto.MailDto;
import com.emailsystem.model.Mail;
import com.emailsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    public void sendToQueue(MailDto mailDto){

        System.out.println("Mail Send Id: "+mailDto.getSenderId()+"\n"+"Mail Receiver Id: "+mailDto.getReceiverId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,mailDto);

    }

}
