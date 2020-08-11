package com.elasticsearch.services;

import com.elasticsearch.model.User;
import com.elasticsearch.repository.UserRepository;
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

    public List<User> search(String search){
        return userRepository.findByAdLikeOrSoyadiLike(search,search);
    }
}
