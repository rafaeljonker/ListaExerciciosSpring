package com.example.bean_validation.mapper;

import com.example.bean_validation.dto.UserDto;
import com.example.bean_validation.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userDtoUser(UserDto userDto);
}
