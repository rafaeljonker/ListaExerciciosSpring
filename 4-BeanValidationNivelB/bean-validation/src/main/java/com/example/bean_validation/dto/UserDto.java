package com.example.bean_validation.dto;

import jakarta.validation.constraints.*;

public class UserDto {
    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    @Pattern(regexp = "^[^\\p{So}\\p{Cn}]*$", message = "O nome não pode conter emojis")
    String name;
    @NotNull(message = "Login não pode ser nulo")
    String login;
    @NotNull(message = "A senha não pode ser vazia")
    String password;

    public UserDto(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
