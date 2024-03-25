package com.github.javashop.service;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;

public interface UserService {

    public UserResponseDto save(UserRequestDto userRequestDto);

    public UserResponseDto save(UserRequestDto userRequestDto, String roleName);
}
