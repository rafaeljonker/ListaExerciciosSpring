package com.example.SecurityWeb.service;

import com.example.SecurityWeb.dto.UserLoginDto;
import com.example.SecurityWeb.dto.UserRegistrationDto;
import com.example.SecurityWeb.mapper.UserRegistrationMapper;
import com.example.SecurityWeb.model.User;
import com.example.SecurityWeb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {



    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registration(UserRegistrationDto userRegistrationDto){
    UserRegistrationMapper userRegistrationMapper = UserRegistrationMapper.INSTANCE;
    User user = userRegistrationMapper.userDtoToUser(userRegistrationDto);
    userRepository.save(user);
}

public void login(UserLoginDto userLoginDto){
    System.out.println(userRepository.findByUsername(userLoginDto.getUsername()));
}

public List<User> getAllUser(){
        return userRepository.findAll();
}

}
