package com.elasticsearch.controllers;

import com.elasticsearch.model.User;
import com.elasticsearch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/Add")
    public ResponseEntity<User> add(@RequestBody User user){
        System.out.println(user.getAd());
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search){
        return ResponseEntity.ok(userService.search(search));
    }

}
