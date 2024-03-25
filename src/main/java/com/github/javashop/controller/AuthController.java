package com.github.javashop.controller;

import com.github.javashop.dto.UserDto;
import com.github.javashop.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public UserDto register(UserDto userDto) {
        return userService.register(userDto);
    }

    @GetMapping("/login")
    public UserDto login(UserDto userDto) {
        return userService.login(userDto);
    }
}
