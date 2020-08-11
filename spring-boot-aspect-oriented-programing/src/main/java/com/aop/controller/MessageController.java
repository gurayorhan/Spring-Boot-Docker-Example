package com.aop.controller;

import com.aop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    private MessageService userService;

    @GetMapping("/List")
    public ResponseEntity<String> lists(){
        return ResponseEntity.ok(userService.Send());
    }

    @GetMapping("/Add")
    public ResponseEntity<String> add(){
        try{
            userService.Error();
        }catch (Exception e){

        }
        return ResponseEntity.ok("Correct");
    }

}
