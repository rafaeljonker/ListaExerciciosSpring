package com.example.SecurityWeb.dto;

import jakarta.validation.constraints.NotNull;

public class UserLoginDto {
  @NotNull(message = "O login não pode ser nulo")
    String username;
  @NotNull(message = "A senha não pode ser nula")
  String password;

  public UserLoginDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public @NotNull(message = "O login não pode ser nulo") String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword( String password) {
    this.password = password;
  }





}
