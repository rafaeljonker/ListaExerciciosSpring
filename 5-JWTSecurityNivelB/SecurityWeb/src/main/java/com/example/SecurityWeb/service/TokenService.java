package com.example.SecurityWeb.service;

import com.example.SecurityWeb.dto.TokenDto;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    String chaveSecreta;
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora


    public TokenDto createToken(String username){
        Map<String,Object> claim = new HashMap();
        claim.put("username",username);
        String token = Jwts.builder().setClaims(claim).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).compact();
        return new TokenDto(token);
    }
}
