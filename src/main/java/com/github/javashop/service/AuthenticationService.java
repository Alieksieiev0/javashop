package com.github.javashop.service;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;

public interface AuthenticationService {
    public void register(UserRequestDto userRequestDto);

    public UserResponseDto login(UserRequestDto userRequestDto);
}
