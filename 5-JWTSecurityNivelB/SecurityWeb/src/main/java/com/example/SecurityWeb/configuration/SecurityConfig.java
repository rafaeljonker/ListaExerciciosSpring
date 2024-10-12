package com.example.SecurityWeb.configuration;


import com.example.SecurityWeb.filter.CustomFilter;
import com.example.SecurityWeb.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    TokenService tokenService;

    SecurityConfig(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Bean
  public SecurityFilterChain configuration(HttpSecurity http, TokenService tokenService) throws Exception {
     return http.cors(AbstractHttpConfigurer::disable)
              .csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(req -> {
                  req.requestMatchers(HttpMethod.POST, "api/auth/**").permitAll()
                 /* remover depois */ .requestMatchers(HttpMethod.GET, "auth/**").permitAll()
                          .anyRequest().authenticated();

              }) .addFilterBefore(new CustomFilter(tokenService), UsernamePasswordAuthenticationFilter.class)
// TOKEN-401
             .build();
  }




}
