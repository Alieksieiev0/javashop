package com.github.javashop.mapper;

import com.github.javashop.config.MapperConfig;
import com.github.javashop.dto.UserDto;
import com.github.javashop.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    @Mapping(target = "role", source = "user.role.name")
    @Mapping(target = "roleId", source = "user.role.id")
    @Mapping(target = "token", ignore = true)
    UserDto toDto(User user);

    @Mapping(target = "role.name", source = "role")
    @Mapping(target = "role.id", source = "roleId")
    @Mapping(target = "deleted", ignore = true)
    User toModel(UserDto user);
}
