package com.example.presscentricapp.exception;

public class ApplicationError extends Error {

    public static Error noUserWithId(Integer id) {
        return new Error(ApplicationErrorMessage.USER_WITH_ID_NOT_FOUND.getMessage().concat(id.toString()));
    }

    public static Error noUsers() {
        return new Error(ApplicationErrorMessage.USERS_NOT_FOUND.getMessage());
    }

    public static Error userCreateDuplicateEmail(String email) {
        return new Error(ApplicationErrorMessage.USER_CREATE_DUPLICATE_EMAIL_ERROR.getMessage().concat(email));
    }

    public static Error invalidIntegerInputParam(Integer id) {
        return new Error(ApplicationErrorMessage.INVALID_INTEGER_INPUT_PARAM.getMessage().concat(id.toString()));
    }
}
