package com.emailsystem.service;

import com.emailsystem.dto.UserDto;
import com.emailsystem.model.User;
import com.emailsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDto add(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserDto.class);
    }

    public UserDto findUser(Long id){
        User user = userRepository.findById(id).get();
        return modelMapper.map(user,UserDto.class);
    }

}
