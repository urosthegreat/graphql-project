package com.example.presscentricapp.mapper;

import com.example.presscentricapp.model.dao.UserDao;
import com.example.presscentricapp.model.entity.UserEntity;
import com.example.presscentricapp.model.input.CreateUserInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    UserDao userEntityToUserDao(UserEntity userEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    UserEntity userDaoToUserEntity(UserDao userDao);

    List<UserDao> userEntityListToUserDaoList(List<UserEntity> users);

    @Mapping(target = "id", ignore = true)
    UserEntity createUserInputToUser(CreateUserInput input);
}

