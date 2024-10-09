package com.example.SecurityWeb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
  public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
     return http.cors(AbstractHttpConfigurer::disable)
              .csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(req -> {
                  req.requestMatchers(HttpMethod.POST, "auth/**").permitAll()
                  .requestMatchers(HttpMethod.GET, "auth/**").permitAll()
                          .anyRequest().authenticated();
              })
// TOKEN-401          .addFilterBefore()
             .build();
  }

}
