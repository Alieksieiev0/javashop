package com.github.javashop.service;

import com.github.javashop.dto.UserDto;

public interface UserService {
    public UserDto register(UserDto userDto);

    public UserDto login(UserDto userDto);
}
