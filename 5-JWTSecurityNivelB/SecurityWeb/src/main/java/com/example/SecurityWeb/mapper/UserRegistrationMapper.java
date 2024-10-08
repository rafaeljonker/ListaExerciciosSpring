package com.example.SecurityWeb.mapper;

import com.example.SecurityWeb.dto.UserRegistrationDto;
import com.example.SecurityWeb.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRegistrationMapper {

    UserRegistrationMapper INSTANCE = Mappers.getMapper(UserRegistrationMapper.class);
    User userDtoToUser(UserRegistrationDto userRegistrationDto );
;
}
