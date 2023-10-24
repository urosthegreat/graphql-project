/**
 * This class defines GraphQL resolvers for user-related operations.
 */
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

/**
 * A component that handles GraphQL queries and mutations related to users.
 */
@DgsComponent
@AllArgsConstructor
public class UserResolver {

    private final UserService userService;

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The user's information.
     */
    @DgsQuery(field = "user")
    public UserDao getUserById(@InputArgument("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of user information.
     */
    @DgsQuery(field = "users")
    public List<UserDao> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Creates a new user with the provided information.
     *
     * @param input The input data for creating a user.
     * @return The created user's information.
     */
    @DgsMutation
    public UserDao createUser(@InputArgument("input") CreateUserInput input) {
        return userService.createUser(input);
    }

    /**
     * Updates an existing user's information.
     *
     * @param id    The unique identifier of the user to be updated.
     * @param input The updated user data.
     * @return The updated user's information.
     */
    @DgsMutation
    public UserDao updateUser(@InputArgument("id") Integer id, @InputArgument("input") UpdateUserInput input) {
        return userService.updateUser(id, input);
    }

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id The unique identifier of the user to be deleted.
     * @return The deleted user's information.
     */
    @DgsMutation
    public UserDao deleteUser(@InputArgument("id") Integer id) {
        return userService.deleteUser(id);
    }
}
