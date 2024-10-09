package com.example.SecurityWeb.service;

import com.example.SecurityWeb.dto.TokenDto;
import com.example.SecurityWeb.dto.UserLoginDto;
import com.example.SecurityWeb.dto.UserRegistrationDto;
import com.example.SecurityWeb.mapper.UserRegistrationMapper;
import com.example.SecurityWeb.model.User;
import com.example.SecurityWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


TokenService tokenService;
    UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
}

    public void registration(UserRegistrationDto userRegistrationDto){
    UserRegistrationMapper userRegistrationMapper = UserRegistrationMapper.INSTANCE;
    User user = userRegistrationMapper.userDtoToUser(userRegistrationDto);
    userRepository.save(user);
}



public List<User> getAllUser(){
        return userRepository.findAll();
}

    public ResponseEntity<TokenDto> login(UserLoginDto userLoginDto){
        Optional<User> user =   userRepository.findByUsername(userLoginDto.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(userLoginDto.getPassword())){

         //injetar um TokenService que gera um token e retorna um token dto.
            return new ResponseEntity<>(tokenService.createToken(userLoginDto.getUsername()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }

}
