package com.mongo.controllers;

import com.mongo.models.User;
import com.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/Add")
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping("/List")
    public ResponseEntity<List<User>> lists(){
        return ResponseEntity.ok(userService.lists());
    }

}
