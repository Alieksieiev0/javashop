package com.github.javashop.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javashop.dto.UserDto;
import com.github.javashop.mapper.UserMapper;
import com.github.javashop.model.User;
import com.github.javashop.repository.UserRepository;
import com.github.javashop.service.JWTService;
import com.github.javashop.service.UserService;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @Override
    public UserDto register(UserDto userDto) {
        if (userDto.getUsername() == null
                || userDto.getEmail() == null
                || userDto.getPassword() == null) {
            throw new NullPointerException();
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.toDto(userRepository.save(userMapper.toModel(userDto)));
    }

    @Override
    public UserDto login(UserDto userDto) {
        if (userDto.getUsername() == null || userDto.getPassword() == null) {
            throw new NullPointerException();
        }
        User user =
                userRepository
                        .findByUsername(userDto.getUsername())
                        .orElseThrow(() -> new EntityNotFoundException("message"));
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new NullPointerException();
        }
        userDto.setPassword(null);
        Map<String, Object> claims =
                new ObjectMapper()
                        .convertValue(userDto, new TypeReference<Map<String, Object>>() {});
        userDto.setToken(jwtService.createJWT(claims));
        return userDto;
    }
}
