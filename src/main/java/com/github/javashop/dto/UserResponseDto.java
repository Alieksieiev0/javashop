package com.github.javashop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserResponseDto extends UserDto {
    private String role;
    private String token;

    public UserResponseDto(@NonNull String username, String role, String token) {
        super(username);
        this.role = role;
        this.token = token;
    }
}
