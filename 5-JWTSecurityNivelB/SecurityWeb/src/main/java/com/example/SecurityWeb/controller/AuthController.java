package com.example.SecurityWeb.controller;


import com.example.SecurityWeb.dto.TokenDto;
import com.example.SecurityWeb.dto.UserLoginDto;
import com.example.SecurityWeb.dto.UserRegistrationDto;
import com.example.SecurityWeb.model.User;
import com.example.SecurityWeb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    UserService userService;

@PostMapping("registration")
public ResponseEntity<String> registration(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
    return userService.registration(userRegistrationDto);
}

    @PostMapping("login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        return (userService.login(userLoginDto));
    }

    @GetMapping("getUser")
    public List<User> getAllUsers(){
    return userService.getAllUser();
    }
}
