package com.example.SecurityWeb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.SecurityWeb.dto.TokenDto;

import com.example.SecurityWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    private static final String secretKey = "4d$Fj9p@8Lk3Zz%2QrWs1Yv!7XnT5bAc";
    private final long EXPIRATION_TIME =  60 * 60; // 1 hora
    private static final String ISSUER = "jonker-api"; // Emissor do token


    public TokenDto createToken(String username){
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String token = JWT.create().withIssuer(ISSUER).withIssuedAt(creationDate()).withExpiresAt(expirationDate()).withSubject(username).sign(algorithm);
        return new TokenDto(token);
    }

    private Instant creationDate(){
        return ZonedDateTime.now(ZoneId.of("America/Fortaleza")).toInstant();
    }
    private Instant expirationDate(){
        return ZonedDateTime.now(ZoneId.of("America/Fortaleza")).toInstant().plusSeconds(EXPIRATION_TIME);
    }

    private String getUsernameToken(String token){
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getSubject();
    }

    private Date getExpirationsDateToken(String token){
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getExpiresAt();
    }

    private Date getCreationDateToken(String token){
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getIssuedAt();
    }

    public Boolean validateToken(String token) {
        if (userRepository.findByUsername(getUsernameToken(token)).isPresent()){
            return getExpirationsDateToken(token).after(getCreationDateToken(token));

    }return false;

    }
}
