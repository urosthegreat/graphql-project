package com.example.presscentricapp.exception;

import lombok.Getter;

@Getter
public enum ApplicationErrorMessage {
    USER_WITH_ID_NOT_FOUND(1, "User was not found with the ID: "),
    USERS_NOT_FOUND(2, "Users not found"),
    USER_CREATE_DUPLICATE_EMAIL_ERROR(3, "User already exists with EMAIL: "),
    INVALID_INTEGER_INPUT_PARAM(4, "Invalid integer input param: ");

    private final int code;
    private final String message;

    ApplicationErrorMessage(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
