package com.github.javashop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserRequestDto extends UserDto {
    @NonNull private String password;

    public UserRequestDto(@NonNull String username, @NonNull String password) {
        super(username);
        this.password = password;
    }
}
