package com.example.bean_validation.controller;


import com.example.bean_validation.dto.UserDto;

import com.example.bean_validation.model.User;
import com.example.bean_validation.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
  LoginService loginService;

  @PostMapping
 public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
      loginService.cadastrarUser(userDto);
      return new ResponseEntity<>("Criado com sucesso", HttpStatus.CREATED);
 }
 @GetMapping()
    public List<User> getAll(){
      return loginService.getAllUsers();
 }

 @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
      return loginService.getById(id).map(user -> ResponseEntity.ok(user)).orElse(ResponseEntity.notFound().build());
 }

}
