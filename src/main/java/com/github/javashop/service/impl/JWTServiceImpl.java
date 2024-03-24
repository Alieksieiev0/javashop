package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.JWT_DURATION_IN_UNIT_TYPE;
import static com.github.javashop.config.Constants.JWT_SECRET_KEY;
import static com.github.javashop.config.Constants.JWT_UNIT_TYPE;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

@Service
public class JWTServiceImpl {

    public String createJWT(Map<String, Object> claims) {
        return Jwts.builder()
                .expiration(getExpiration(JWT_UNIT_TYPE, JWT_DURATION_IN_UNIT_TYPE))
                .issuedAt(new Date())
                .claims(claims)
                .signWith(getKey())
                .compact();
    }

    public Map<String, Object> readJWT(String token, Set<String> claimKeys) {
        Jws<Claims> jws;

        jws = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token);
        return jws.getPayload().entrySet().stream()
                .filter(e -> claimKeys.contains(e.getKey()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
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
