package com.example.presscentricapp.resolver;

import com.example.presscentricapp.model.dao.UserDao;
import com.example.presscentricapp.model.input.CreateUserInput;
import com.example.presscentricapp.model.input.UpdateUserInput;
import com.example.presscentricapp.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;

import java.util.List;

@DgsComponent
@AllArgsConstructor
public class UserResolver {

    private final UserService userService;

    @DgsQuery(field = "user")
    public UserDao getUserById(@InputArgument("id") Integer id) {
        return userService.getUserById(id);
    }

    @DgsQuery(field = "users")
    public List<UserDao> getAllUsers() {
        return userService.getAllUsers();
    }

    @DgsMutation
    public UserDao createUser(@InputArgument("input") CreateUserInput input) {
        return userService.createUser(input);
    }

    @DgsMutation
    public UserDao updateUser(@InputArgument("id") Integer id, @InputArgument("input") UpdateUserInput input) {
        return userService.updateUser(id, input);
    }

    @DgsMutation
    public UserDao deleteUser(@InputArgument("id") Integer id) {
        return userService.deleteUser(id);
    }
}
