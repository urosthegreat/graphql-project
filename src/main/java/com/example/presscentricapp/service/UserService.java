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

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ValidationCheck validationCheck;

    public UserDao getUserById(Integer id) {
        if (!validationCheck.isIntegerParamValid(id)) {
            throw new ApplicationException(ApplicationError.invalidIntegerInputParam(id));
        }
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ApplicationError.noUserWithId(id)));

        return userMapper.userEntityToUserDao(userEntity);
    }

    public List<UserDao> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList.isEmpty()) {
            throw new ApplicationException(ApplicationError.noUsers());
        }

        return userMapper.userEntityListToUserDaoList(userEntityList);
    }

    public UserDao createUser(CreateUserInput input) {
        Optional<UserEntity> userEntityExisting = userRepository.findByEmail(input.getEmail());
        if (userEntityExisting.isPresent()) {
            throw new ApplicationException(ApplicationError.userCreateDuplicateEmail(input.getEmail()));
        }
        UserEntity userEntityNew = userMapper.createUserInputToUser(input);

        userRepository.save(userEntityNew);

        return userMapper.userEntityToUserDao(userEntityNew);
    }

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

    public UserDao deleteUser(Integer id) {
        validationCheck.isIntegerParamValid(id);
        UserDao userDao = this.getUserById(id);

        userRepository.deleteById(userDao.getId());

        return userDao;
    }
}
