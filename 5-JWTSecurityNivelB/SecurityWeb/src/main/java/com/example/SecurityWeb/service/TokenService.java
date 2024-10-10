package com.example.SecurityWeb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.SecurityWeb.dto.TokenDto;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    private static final String secretKey = "4d$Fj9p@8Lk3Zz%2QrWs1Yv!7XnT5bAc";
    private final long EXPIRATION_TIME =  60 * 60; // 1 hora
    private static final String ISSUER = "jonker-api"; // Emissor do token


    public TokenDto createToken(String username){
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String token = JWT.create().withIssuer(ISSUER).withIssuedAt(creationDate()).withExpiresAt(expirationDate()).withSubject(username).sign(algorithm);
        return new TokenDto(token);
    }
    

    //VALIDAR O TOKEN E DE ALGUMA MANEIRA INTERCEPTAR A REQUISIÇÂO
    public void validateToken(String token){}

    private Instant creationDate(){
        return ZonedDateTime.now(ZoneId.of("America/Fortaleza")).toInstant();
    }

    private Instant expirationDate(){
        return Instant.now().plusSeconds(EXPIRATION_TIME);
    }
}
