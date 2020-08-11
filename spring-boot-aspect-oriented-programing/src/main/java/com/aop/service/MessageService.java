package com.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String Send(){
        return "Aspect Oriented Programing Learning";
    }

    public void Error() throws Exception {
        throw new Exception();
    }
}
