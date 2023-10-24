/**
 * This class defines custom application errors for the PressCentric application.
 */
package com.example.presscentricapp.exception;

/**
 * Custom application error class that extends the base Error class.
 */
public class ApplicationError extends Error {

    /**
     * Creates an error indicating that a user with the specified ID was not found.
     *
     * @param id The unique identifier of the user.
     * @return An error message indicating that no user with the given ID was found.
     */
    public static Error noUserWithId(Integer id) {
        return new Error(ApplicationErrorMessage.USER_WITH_ID_NOT_FOUND.getMessage().concat(id.toString()));
    }

    /**
     * Creates an error indicating that no users were found.
     *
     * @return An error message indicating that no users were found.
     */
    public static Error noUsers() {
        return new Error(ApplicationErrorMessage.USERS_NOT_FOUND.getMessage());
    }

    /**
     * Creates an error indicating a duplicate email during user creation.
     *
     * @param email The email address that caused the duplicate error.
     * @return An error message indicating that a user with the given email already exists.
     */
    public static Error userCreateDuplicateEmail(String email) {
        return new Error(ApplicationErrorMessage.USER_CREATE_DUPLICATE_EMAIL_ERROR.getMessage().concat(email));
    }

    /**
     * Creates an error indicating an invalid integer input parameter.
     *
     * @param id The invalid integer input value.
     * @return An error message indicating an invalid integer input parameter.
     */
    public static Error invalidIntegerInputParam(Integer id) {
        return new Error(ApplicationErrorMessage.INVALID_INTEGER_INPUT_PARAM.getMessage().concat(id.toString()));
    }
}
