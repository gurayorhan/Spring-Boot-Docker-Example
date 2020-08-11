package com.emailsystem.service;


import com.emailsystem.dto.MailDto;
import com.emailsystem.model.Mail;
import com.emailsystem.model.User;
import com.emailsystem.repository.MailRepository;
import com.emailsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailRepository mailRepository;

    public void add(MailDto mailDto){
        Mail mail = modelMapper.map(mailDto, Mail.class);
        mail.setSender(userRepository.findById(mailDto.getSenderId()).get());
        mail.setReceiver(userRepository.findById(mailDto.getReceiverId()).get());
        mailRepository.save(mail);
    }

    public List<MailDto> recevierMailList(Long id){
        List<Mail> mailList = mailRepository.findByReceiver(id);
        List<MailDto> mailDtos = new ArrayList<>();

        for (Mail mail:mailList) {
            mailDtos.add(modelMapper.map(mail,MailDto.class));
        }

        return mailDtos;
    }

    public List<MailDto> senderMailList(Long id){
        List<Mail> mailList = mailRepository.findBySender(id);
        List<MailDto> mailDtos = new ArrayList<>();

        for (Mail mail:mailList) {
            mailDtos.add(modelMapper.map(mail,MailDto.class));
        }

        return mailDtos;
    }

    public List<MailDto> senderOrReceiverMailList(Long id){
        List<Mail> mailList = mailRepository.findBySenderOrReceiver(id,id);
        List<MailDto> mailDtos = new ArrayList<>();

        for (Mail mail:mailList) {
            mailDtos.add(modelMapper.map(mail,MailDto.class));
        }

        return mailDtos;
    }

}
