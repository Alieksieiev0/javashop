package com.github.javashop.mapper;

import com.github.javashop.config.MapperConfig;
import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;
import com.github.javashop.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    @Mapping(target = "role", source = "user.role.name")
    @Mapping(target = "token", ignore = true)
    UserResponseDto toResponseDto(User user);

    @Mapping(target = "role", source = "user.role.name")
    UserResponseDto toResponseDto(User user, String token);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    User toModel(UserRequestDto user);
}
