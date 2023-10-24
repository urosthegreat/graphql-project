/**
 * This class represents custom application exceptions for the PressCentric application.
 */
package com.example.presscentricapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * A custom runtime exception that encapsulates an error and an HTTP status code.
 */
@Getter
public class ApplicationException extends RuntimeException {

    /**
     * The error that triggered the exception.
     */
    public final Error error;

    /**
     * The HTTP status code associated with the exception.
     */
    public final int statusCode;

    /**
     * Constructs an application exception with the specified error and a default status code (BAD_REQUEST).
     *
     * @param error The error that triggered the exception.
     */
    public ApplicationException(Error error) {
        super(error.getMessage());
        this.error = error;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    /**
     * Constructs an application exception with the specified error and HTTP status code.
     *
     * @param error      The error that triggered the exception.
     * @param statusCode The HTTP status code associated with the exception.
     */
    public ApplicationException(Error error, HttpStatus statusCode) {
        super(error.getMessage());
        this.error = error;
        this.statusCode = statusCode.value();
    }
}
