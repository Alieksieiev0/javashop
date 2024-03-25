package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.PASSWORD;
import static com.github.javashop.config.Constants.ROLE;
import static com.github.javashop.config.Constants.USERNAME;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;
import com.github.javashop.mapper.UserMapper;
import com.github.javashop.model.Role;
import com.github.javashop.model.User;
import com.github.javashop.repository.UserRepository;
import com.github.javashop.service.AuthenticationService;
import com.github.javashop.service.JWTService;
import com.github.javashop.service.UserService;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final String EMAIL_WAS_NOT_PROVIDED = "User Email was not provided";
    private final String USER_DOES_NOT_EXIST = "User with provided username does not exist:";
    private final String INCORRECT_PASSWORD = "Provided password is incorrect";

    @Override
    public void register(UserRequestDto userRequestDto) throws NullPointerException {
        if (userRequestDto.getEmail() == null) {
            throw new NullPointerException(EMAIL_WAS_NOT_PROVIDED);
        }
        userService.save(userRequestDto);
    }

    @Override
    public UserResponseDto login(UserRequestDto userRequestDto) {
        User user =
                userRepository
                        .findByUsername(userRequestDto.getUsername())
                        .orElseThrow(
                                () ->
                                        new EntityNotFoundException(
                                                USER_DOES_NOT_EXIST
                                                        + userRequestDto.getUsername()));

        if (!passwordEncoder.matches(userRequestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(INCORRECT_PASSWORD);
        }

        return userMapper.toResponseDto(
                user, jwtService.createJWT(getClaims(userRequestDto, user.getRole())));
    }

    private Map<String, Object> getClaims(UserRequestDto userRequestDto, Role role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(USERNAME, userRequestDto.getUsername());
        claims.put(PASSWORD, userRequestDto.getPassword());
        claims.put(ROLE, role.getName());

        return claims;
    }
}
