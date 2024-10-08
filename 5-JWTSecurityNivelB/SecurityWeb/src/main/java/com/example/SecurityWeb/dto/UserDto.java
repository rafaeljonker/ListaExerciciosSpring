package com.example.SecurityWeb.dto;

import jakarta.validation.constraints.NotNull;

public class UserDto {
@NotNull(message = "não pode ser nulo") private String username;
@NotNull(message = "não pode ser nulo") private String password;

    public UserDto(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
    }


    public @NotNull(message = "não pode ser nulo") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(message = "não pode ser nulo") String username) {
        this.username = username;
    }

    public @NotNull(message = "não pode ser nulo") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "não pode ser nulo") String password) {
        this.password = password;
    }





}
