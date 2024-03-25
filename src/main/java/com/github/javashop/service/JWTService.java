package com.github.javashop.service;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;

import java.util.Map;

public interface JWTService {
    public String createJWT(Map<String, Object> claims);

    public Jwt readJWT(String token) throws JwtException;
}
