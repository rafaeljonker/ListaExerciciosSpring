package com.example.SecurityWeb.dto;

public class TokenDto  {


    String token;
    public TokenDto (String token) {
        this.token = token;
    }


    public String getToken() {
        return token;
    }

}
