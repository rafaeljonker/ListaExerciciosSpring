package com.example.bean_validation.controller;


import com.example.bean_validation.dto.UserDto;
import com.example.bean_validation.model.User;
import com.example.bean_validation.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
  LoginService loginService;

  @PostMapping("login")
 public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
      User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getName());
      loginService.login(user);
      return new ResponseEntity<>("Criado com sucesso", HttpStatus.CREATED);

 }

}
