package com.example.bean_validation.service;

import com.example.bean_validation.dto.UserDto;
import com.example.bean_validation.mapper.UserMapper;
import com.example.bean_validation.model.User;
import com.example.bean_validation.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public void cadastrarUser(UserDto userDto){
        UserMapper userMapper = UserMapper.INSTANCE;
        User user = userMapper.userDtoUser(userDto);
        loginRepository.save(user);

    }
    public List<User> getAllUsers(){
       List<User> users = loginRepository.findAll();

       if(users.isEmpty()){
           return null;
       }
       else{
           return users;
        }
    }

    public Optional<User> getById(Long id){
        return loginRepository.findById(id);
    }

}
