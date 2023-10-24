/**
 * This mapper interface converts between user-related data transfer objects (DTOs) and user entities.
 */
package com.example.presscentricapp.mapper;

import com.example.presscentricapp.model.dao.UserDao;
import com.example.presscentricapp.model.entity.UserEntity;
import com.example.presscentricapp.model.input.CreateUserInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * A Spring component for mapping between user entities, user data transfer objects, and input data.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a user entity to a user data transfer object (DTO).
     *
     * @param userEntity The user entity to be converted.
     * @return The corresponding user data transfer object.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    UserDao userEntityToUserDao(UserEntity userEntity);

    /**
     * Converts a user data transfer object (DTO) to a user entity.
     *
     * @param userDao The user data transfer object to be converted.
     * @return The corresponding user entity.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    UserEntity userDaoToUserEntity(UserDao userDao);

    /**
     * Converts a list of user entities to a list of user data transfer objects (DTOs).
     *
     * @param users The list of user entities to be converted.
     * @return The corresponding list of user data transfer objects.
     */
    List<UserDao> userEntityListToUserDaoList(List<UserEntity> users);

    /**
     * Converts user creation input data to a user entity.
     *
     * @param input The input data for creating a user.
     * @return The corresponding user entity.
     */
    @Mapping(target = "id", ignore = true)
    UserEntity createUserInputToUser(CreateUserInput input);
}
