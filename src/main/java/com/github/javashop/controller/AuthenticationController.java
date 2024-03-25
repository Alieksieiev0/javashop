package com.github.javashop.controller;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;
import com.github.javashop.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        System.out.println("----------------------------");
        System.out.println(userRequestDto);
        System.out.println(userRequestDto.getEmail());
        System.out.println(userRequestDto.getUsername());
        authenticationService.register(userRequestDto);
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody UserRequestDto userRequestDto) {
        return authenticationService.login(userRequestDto);
    }
}
