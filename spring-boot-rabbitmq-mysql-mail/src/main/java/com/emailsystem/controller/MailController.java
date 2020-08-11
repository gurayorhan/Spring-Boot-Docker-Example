package com.emailsystem.controller;

import com.emailsystem.dto.MailDto;
import com.emailsystem.producer.MailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Mail")
public class MailController {

    @Autowired
    private MailProducer mailProducer;

    @PostMapping("/Send")
    public ResponseEntity<Boolean> send(@RequestBody MailDto mailDto){
        try {
            mailProducer.sendToQueue(mailDto);
            return ResponseEntity.ok(Boolean.TRUE);
        }catch (Exception e){
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }

}
