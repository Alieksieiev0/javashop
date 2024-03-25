package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.JWT_DURATION_IN_UNIT_TYPE;
import static com.github.javashop.config.Constants.JWT_SECRET_KEY;
import static com.github.javashop.config.Constants.JWT_UNIT_TYPE;

import com.github.javashop.service.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

@Service
public class JWTServiceImpl implements JWTService {

    public String createJWT(Map<String, Object> claims) {
        return Jwts.builder()
                .expiration(getExpiration(JWT_UNIT_TYPE, JWT_DURATION_IN_UNIT_TYPE))
                .issuedAt(new Date())
                .claims(claims)
                .signWith(getKey())
                .compact();
    }

    public Jwt readJWT(String token) throws JwtException {
        Jws<Claims> jws;

        try {
            jws = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token);
        } catch (io.jsonwebtoken.JwtException ex) {
            throw new JwtException("Couldn`t validate JWT token");
        }

        Claims payload = jws.getPayload();
        Map<String, Object> headers =
                jws.getHeader().entrySet().stream()
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        Map<String, Object> claims =
                payload.entrySet().stream()
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        return new Jwt(
                token,
                payload.getIssuedAt().toInstant(),
                payload.getExpiration().toInstant(),
                headers,
                claims);
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET_KEY));
    }

    private Date getExpiration(int unitType, int tokenDurationInUnitType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(unitType, tokenDurationInUnitType);
        return calendar.getTime();
    }
}
