package com.github.javashop.service;

import com.github.javashop.dto.UserDto;

public interface UserService {
    public UserDto register();

    public UserDto login();
}
