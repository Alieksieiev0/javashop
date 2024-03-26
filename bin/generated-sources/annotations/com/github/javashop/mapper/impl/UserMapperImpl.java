package com.github.javashop.mapper.impl;

import com.github.javashop.dto.UserRequestDto;
import com.github.javashop.dto.UserResponseDto;
import com.github.javashop.mapper.UserMapper;
import com.github.javashop.model.Role;
import com.github.javashop.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T22:33:04+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240318-1716, environment: Java 17.0.10 (N/A)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        String role = null;
        String username = null;

        String name = userRoleName( user );
        if ( name != null ) {
            role = name;
        }
        if ( user.getUsername() != null ) {
            username = user.getUsername();
        }

        String token = null;

        UserResponseDto userResponseDto = new UserResponseDto( username, role, token );

        if ( user.getEmail() != null ) {
            userResponseDto.setEmail( user.getEmail() );
        }

        return userResponseDto;
    }

    @Override
    public UserResponseDto toResponseDto(User user, String token) {
        if ( user == null && token == null ) {
            return null;
        }

        String role = null;
        String username = null;
        if ( user != null ) {
            String name = userRoleName( user );
            if ( name != null ) {
                role = name;
            }
            if ( user.getUsername() != null ) {
                username = user.getUsername();
            }
        }
        String token1 = null;
        if ( token != null ) {
            token1 = token;
        }

        UserResponseDto userResponseDto = new UserResponseDto( username, role, token1 );

        if ( user != null ) {
            if ( user.getEmail() != null ) {
                userResponseDto.setEmail( user.getEmail() );
            }
        }

        return userResponseDto;
    }

    @Override
    public User toModel(UserRequestDto user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        if ( user.getEmail() != null ) {
            user1.setEmail( user.getEmail() );
        }
        if ( user.getPassword() != null ) {
            user1.setPassword( user.getPassword() );
        }
        if ( user.getUsername() != null ) {
            user1.setUsername( user.getUsername() );
        }

        return user1;
    }

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
