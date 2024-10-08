package com.example.SecurityWeb.dto;

import jakarta.validation.constraints.NotNull;

public class UserRegistrationDto {
    @NotNull(message = "não pode ser nulo") private String username;
    @NotNull(message = "não pode ser nulo") private String repeatPassword;
    @NotNull(message = "não pode ser nulo") private String password;

    public UserRegistrationDto(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
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

    public @NotNull(message = "não pode ser nulo") String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(@NotNull(message = "não pode ser nulo") String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }




}
