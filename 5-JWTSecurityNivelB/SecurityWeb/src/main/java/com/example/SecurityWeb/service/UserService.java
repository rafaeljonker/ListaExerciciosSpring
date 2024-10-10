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

    public ResponseEntity<String> registration(UserRegistrationDto userRegistrationDto){
    if(userRepository.findByUsername(userRegistrationDto.getUsername()).isEmpty() && userRegistrationDto.getPassword().equals(userRegistrationDto.getRepeatPassword())){
    UserRegistrationMapper userRegistrationMapper = UserRegistrationMapper.INSTANCE;
    User user = userRegistrationMapper.userDtoToUser(userRegistrationDto);
    userRepository.save(user);
    return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.CREATED);
    }
    return new ResponseEntity<>("Erro ao cadastrar usuario", HttpStatus.BAD_REQUEST);
}



public List<User> getAllUser(){
        return userRepository.findAll();
}

    public ResponseEntity<TokenDto> login(UserLoginDto userLoginDto){
        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(userLoginDto.getPassword())){
            return new ResponseEntity<>(tokenService.createToken(userLoginDto.getUsername()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }

}
