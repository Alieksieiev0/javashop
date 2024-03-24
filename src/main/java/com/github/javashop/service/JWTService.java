package com.github.javashop.service;

import java.util.Map;
import java.util.Set;

public interface JWTService {
    public String createJWT(Map<String, Object> claims);

    public Map<String, Object> readJWT(String token, Set<String> claimKeys);
}
