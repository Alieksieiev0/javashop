package com.github.javashop.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull private String username;
    private String email;
}
