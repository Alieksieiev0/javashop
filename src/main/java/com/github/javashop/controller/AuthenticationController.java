package com.github.javashop.controller;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequestDto userRequestDto) {
        Map<String, String> responseToken = new HashMap<>();
        responseToken.put("token", authenticationService.login(userRequestDto));
        return ResponseEntity.ok(responseToken);
    }
}
