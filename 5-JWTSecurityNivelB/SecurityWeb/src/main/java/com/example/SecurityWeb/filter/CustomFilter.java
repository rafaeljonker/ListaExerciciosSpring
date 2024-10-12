package com.example.SecurityWeb.filter;

import com.example.SecurityWeb.service.TokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CustomFilter implements Filter {
    private final TokenService tokenService;

    public CustomFilter(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if (httpRequest.getContentLength() == 0){
            throw new ServletException("Corpo da requisição é obrigatório");
        }

        String token = httpRequest.getHeader("Authorization");

        if(token == null || !tokenService.validateToken(token)){
            throw new ServletException("Token invalido");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
