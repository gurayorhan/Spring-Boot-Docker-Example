package com.mongo.services;

import com.mongo.repository.UserRepository;
import com.mongo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }

    public List<User> lists(){
        return userRepository.findAll();
    }
}
