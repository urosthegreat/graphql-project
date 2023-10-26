package com.example.presscentricapp.service;

import com.example.presscentricapp.exception.ApplicationException;
import com.example.presscentricapp.mapper.UserMapper;
import com.example.presscentricapp.model.dao.UserDao;
import com.example.presscentricapp.model.entity.UserEntity;
import com.example.presscentricapp.model.input.CreateUserInput;
import com.example.presscentricapp.model.input.UpdateUserInput;
import com.example.presscentricapp.repository.UserRepository;
import com.example.presscentricapp.validation.ValidationCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private ValidationCheck validationCheck;
    @InjectMocks
    private UserService userService;

    @Nested
    @DisplayName("GetUserByIdTests")
    class GetUserById {
        @Test
        void testGetUserById_ValidInput() {
            Integer validId = 1;
            UserEntity userEntity = new UserEntity();

            when(validationCheck.isIntegerParamValid(validId)).thenReturn(true);
            when(userRepository.findById(validId)).thenReturn(Optional.of(userEntity));
            when(userMapper.userEntityToUserDao(userEntity)).thenReturn(new UserDao());

            UserDao result = userService.getUserById(validId);

            assertNotNull(result);
        }

        @Test
        void testGetUserById_InvalidInput() {
            Integer invalidId = null;

            when(validationCheck.isIntegerParamValid(invalidId)).thenReturn(false);

            assertThrows(ApplicationException.class, () -> userService.getUserById(invalidId));
        }

        @Test
        void testGetUserById_NoUserFound() {
            Integer validId = 2;

            when(validationCheck.isIntegerParamValid(validId)).thenReturn(true);
            when(userRepository.findById(validId)).thenReturn(Optional.empty());

            assertThrows(ApplicationException.class, () -> userService.getUserById(validId));
        }
    }

    @Nested
    @DisplayName("GetAllUsersTests")
    class GetAllUsers {
        @Test
        void testGetAllUsers_WithUsersFound() {
            List<UserEntity> userEntityList = Collections.singletonList(new UserEntity());
            when(userRepository.findAll()).thenReturn(userEntityList);
            when(userMapper.userEntityListToUserDaoList(userEntityList)).thenReturn(Collections.singletonList(new UserDao()));

            List<UserDao> result = userService.getAllUsers();

            assertFalse(result.isEmpty());
        }

        @Test
        void testGetAllUsers_WithNoUsersFound() {
            when(userRepository.findAll()).thenReturn(Collections.emptyList());

            assertThrows(ApplicationException.class, () -> userService.getAllUsers());
        }
    }

    @Nested
    @DisplayName("CreateUserTests")
    class CreateUser {
        @Test
        void testCreateUser_Successfully() {
            CreateUserInput input = new CreateUserInput();
            input.setEmail("newuser@example.com");
            input.setName("New User");

            UserEntity newUserEntity = new UserEntity();
            UserDao userDao = new UserDao();
            userDao.setName("New User");
            userDao.setEmail("newuser@example.com");

            when(userRepository.findByEmail(input.getEmail())).thenReturn(Optional.empty());
            when(userMapper.createUserInputToUser(input)).thenReturn(newUserEntity);
            when(userMapper.userEntityToUserDao(newUserEntity)).thenReturn(userDao);

            UserDao result = userService.createUser(input);

            assertNotNull(result);
            assertEquals("newuser@example.com", result.getEmail());
            assertEquals("New User", result.getName());
        }

        @Test
        void testCreateUser_DuplicateEmail() {
            CreateUserInput input = new CreateUserInput();
            input.setEmail("duplicateUser@example.com");
            input.setName("New User");

            UserEntity existingUserEntity = new UserEntity();

            when(userRepository.findByEmail(input.getEmail())).thenReturn(Optional.of(existingUserEntity));

            assertThrows(ApplicationException.class, () -> userService.createUser(input));
        }
    }

    @Nested
    @DisplayName("UpdateUserTests")
    class UpdateUser {
        @Test
        void testUpdateUser_ValidInput() {
            Integer userId = 1;
            UpdateUserInput input = new UpdateUserInput();
            input.setEmail("newemail@example.com");
            input.setName("New Name");

            UserDao existingUserDao = new UserDao();
            existingUserDao.setId(userId);
            existingUserDao.setEmail("Old Name");
            existingUserDao.setName("oldemail@example.com");

            UserEntity existingUserEntity = new UserEntity();
            existingUserEntity.setId(userId);
            existingUserEntity.setEmail("oldemail@example.com");
            existingUserEntity.setName("Old Name");

            when(validationCheck.isIntegerParamValid(userId)).thenReturn(true);
            when(userRepository.findById(userId)).thenReturn(Optional.of(existingUserEntity));
            when(userMapper.userEntityToUserDao(existingUserEntity)).thenReturn(existingUserDao);
            when(userMapper.userDaoToUserEntity(existingUserDao)).thenReturn(existingUserEntity);

            UserDao result = userService.updateUser(userId, input);

            assertNotNull(result);
            assertEquals(input.getName(), result.getName());
            assertEquals(input.getEmail(), result.getEmail());
        }
    }

    @Nested
    @DisplayName("DeleteUserTests")
    class DeleteUser {
        @Test
        void testDeleteUser_InvalidInput() {
            Integer userId = null;
            when(validationCheck.isIntegerParamValid(userId)).thenReturn(false);

            assertThrows(ApplicationException.class, () -> userService.deleteUser(userId));
        }

        @Test
        void testGetUserById_ValidInput() {
            Integer userId = 1;
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userId);
            userEntity.setName("Test User");
            userEntity.setEmail("test@example.com");

            UserDao userDao = new UserDao();
            userDao.setId(userId);
            userDao.setName("Test User");
            userDao.setEmail("test@example.com");

            when(validationCheck.isIntegerParamValid(userId)).thenReturn(true);
            when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
            when(userMapper.userEntityToUserDao(userEntity)).thenReturn(userDao);

            UserDao result = userService.getUserById(userId);

            assertNotNull(result);
            assertEquals(userId, result.getId());
        }

        @Test
        void testGetUserById_InvalidInput() {
            Integer userId = null;
            when(validationCheck.isIntegerParamValid(userId)).thenReturn(false);

            assertThrows(ApplicationException.class, () -> userService.getUserById(userId));
        }

        @Test
        void testGetUserById_UserNotFound() {
            Integer userId = 2;

            when(validationCheck.isIntegerParamValid(userId)).thenReturn(true);
            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            assertThrows(ApplicationException.class, () -> userService.getUserById(userId));
        }
    }
}