package com.example.SecurityWeb.dto;

import jakarta.validation.constraints.NotNull;

public class UserDto {
@NotNull(message = "não pode ser nulo") private String username;


    public UserDto(String username, String password) {
        this.username = username;

    }

    public String getUsername() {
        return username;
    }
    public void setUsername( String username) {
        this.username = username;
    }






}
