/**
 * This enumeration defines custom error messages for the PressCentric application.
 */
package com.example.presscentricapp.exception;

/**
 * An enumeration of custom error messages with associated error codes.
 */
import lombok.Getter;

@Getter
public enum ApplicationErrorMessage {
    /**
     * Error message for when a user with a specific ID is not found.
     */
    USER_WITH_ID_NOT_FOUND(1, "User was not found with the ID: "),

    /**
     * Error message for when no users are found.
     */
    USERS_NOT_FOUND(2, "Users not found"),

    /**
     * Error message for a duplicate email during user creation.
     */
    USER_CREATE_DUPLICATE_EMAIL_ERROR(3, "User already exists with EMAIL: "),

    /**
     * Error message for an invalid integer input parameter.
     */
    INVALID_INTEGER_INPUT_PARAM(4, "Invalid integer input param: ");

    private final int code;
    private final String message;

    /**
     * Constructs an application error message with a specified error code and message.
     *
     * @param code    The error code.
     * @param message The error message.
     */
    ApplicationErrorMessage(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
