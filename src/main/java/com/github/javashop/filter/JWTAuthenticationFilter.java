package com.github.javashop.filter;

import static com.github.javashop.config.Constants.PASSWORD;
import static com.github.javashop.config.Constants.ROLE;
import static com.github.javashop.config.Constants.USERNAME;

import com.github.javashop.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String token = parseToken(request.getHeader(HttpHeaders.AUTHORIZATION));
        if (token.isEmpty()) {
            chain.doFilter(request, response);
            return;
        }

        Jwt jwt;
        try {
            jwt = jwtService.readJWT(token);
        } catch (JwtException ex) {
            chain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(getAuthentication(request, jwt));
        chain.doFilter(request, response);
    }

    private String parseToken(String header) {
        if (header == null || !header.startsWith(BEARER)) {
            return "";
        }

        return header.split(" ")[1].trim();
    }

    private UsernamePasswordAuthenticationToken getAuthentication(
            HttpServletRequest request, Jwt jwt) {
        UserDetails userDetails =
                User.builder()
                        .username(jwt.getClaim(USERNAME))
                        .password(jwt.getClaim(PASSWORD))
                        .roles((String) jwt.getClaim(ROLE))
                        .build();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authentication;
    }
}
