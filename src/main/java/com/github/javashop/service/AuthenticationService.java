package com.github.javashop.service;

import com.github.javashop.dto.UserRequestDto;

public interface AuthenticationService {
    public void register(UserRequestDto userRequestDto);

    public String login(UserRequestDto userRequestDto);
}
