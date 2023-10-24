/**
 * This class represents the service layer for managing user-related operations in the PressCentric application.
 */
package com.example.presscentricapp.service;

import com.example.presscentricapp.exception.ApplicationError;
import com.example.presscentricapp.exception.ApplicationException;
import com.example.presscentricapp.mapper.UserMapper;
import com.example.presscentricapp.model.dao.UserDao;
import com.example.presscentricapp.model.entity.UserEntity;
import com.example.presscentricapp.model.input.CreateUserInput;
import com.example.presscentricapp.model.input.UpdateUserInput;
import com.example.presscentricapp.repository.UserRepository;
import com.example.presscentricapp.validation.ValidationCheck;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A service class responsible for managing user-related operations such as retrieval, creation, update, and deletion.
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ValidationCheck validationCheck;

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id The unique identifier of the user to retrieve.
     * @return A data transfer object (DTO) representing the retrieved user.
     * @throws ApplicationException if the provided identifier is invalid or the user is not found.
     */
    public UserDao getUserById(Integer id) {
        if (!validationCheck.isIntegerParamValid(id)) {
            throw new ApplicationException(ApplicationError.invalidIntegerInputParam(id));
        }
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ApplicationError.noUserWithId(id)));

        return userMapper.userEntityToUserDao(userEntity);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of data transfer objects (DTOs) representing users.
     * @throws ApplicationException if no users are found.
     */
    public List<UserDao> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList.isEmpty()) {
            throw new ApplicationException(ApplicationError.noUsers());
        }

        return userMapper.userEntityListToUserDaoList(userEntityList);
    }

    /**
     * Creates a new user with the provided input data.
     *
     * @param input The input data for creating a new user.
     * @return A data transfer object (DTO) representing the newly created user.
     * @throws ApplicationException if a user with the same email already exists.
     */
    public UserDao createUser(CreateUserInput input) {
        Optional<UserEntity> userEntityExisting = userRepository.findByEmail(input.getEmail());
        if (userEntityExisting.isPresent()) {
            throw new ApplicationException(ApplicationError.userCreateDuplicateEmail(input.getEmail()));
        }
        UserEntity userEntityNew = userMapper.createUserInputToUser(input);

        userRepository.save(userEntityNew);

        return userMapper.userEntityToUserDao(userEntityNew);
    }

    /**
     * Updates an existing user with the provided input data.
     *
     * @param id    The unique identifier of the user to update.
     * @param input The input data for updating the user.
     * @return A data transfer object (DTO) representing the updated user.
     * @throws ApplicationException if the provided user ID is invalid or the user is not found.
     */
    public UserDao updateUser(Integer id, UpdateUserInput input) {
        UserDao userDao = this.getUserById(id);

        if (input.getName() != null
                && !input.getName().isEmpty()
                && !input.getName().equalsIgnoreCase(userDao.getName())) {
            userDao.setName(input.getName());
        }
        if (input.getEmail() != null
                && !input.getEmail().isEmpty()
                && !input.getEmail().equalsIgnoreCase(userDao.getEmail())) {
            userDao.setName(input.getEmail());
        }

        UserEntity userEntity = userMapper.userDaoToUserEntity(userDao);
        userRepository.save(userEntity);

        return userMapper.userEntityToUserDao(userEntity);
    }

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id The unique identifier of the user to delete.
     * @return A data transfer object (DTO) representing the deleted user.
     * @throws ApplicationException if the provided user ID is invalid or the user is not found.
     */
    public UserDao deleteUser(Integer id) {
        validationCheck.isIntegerParamValid(id);
        UserDao userDao = this.getUserById(id);

        userRepository.deleteById(userDao.getId());

        return userDao;
    }
}
