package com.github.javashop.dto;


import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String role;
    private UUID roleId;
    private String token;
}
