package com.example.SecurityWeb.controller;


import com.example.SecurityWeb.dto.UserRegistrationDto;
import com.example.SecurityWeb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class LoginController {
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    UserService userService;

@PostMapping("registration")
public ResponseEntity<String> registration(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
    userService.registration(userRegistrationDto);
    return new ResponseEntity<>("Usuario cadastrado com sucesso", HttpStatus.CREATED);
}

    @GetMapping("teste")
    public String registrationa() {
       // userService.registration(userRegistrationDto);
        return "Vc esta logado";
    }
}
