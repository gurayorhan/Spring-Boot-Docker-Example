package com.emailsystem.controller;

import com.emailsystem.dto.UserDto;
import com.emailsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/Add")
    public ResponseEntity<UserDto> send(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.add(userDto));
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.findUser(id));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }
}
