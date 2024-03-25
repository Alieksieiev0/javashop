package com.github.javashop.service.impl;

import static com.github.javashop.config.Constants.ROLE_USER;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;
import com.github.javashop.mapper.UserMapper;
import com.github.javashop.model.Role;
import com.github.javashop.model.User;
import com.github.javashop.repository.RoleRepository;
import com.github.javashop.repository.UserRepository;
import com.github.javashop.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String ROLE_DOES_NOT_EXIST = "Provided/Default Role for the user does not exist";

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        return save(userRequestDto, ROLE_USER);
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto, String roleName) {
        Role role =
                roleRepository
                        .findByName(roleName)
                        .orElseThrow(() -> new NoSuchElementException(ROLE_DOES_NOT_EXIST));

        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        User user = userMapper.toModel(userRequestDto);
        user.setRole(role);

        return userMapper.toResponseDto(userRepository.save(user));
    }
}
