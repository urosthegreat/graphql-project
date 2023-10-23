package com.example.presscentricapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {
    public final Error error;
    public final int statusCode;

    public ApplicationException(Error error) {
        super(error.getMessage());
        this.error = error;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public ApplicationException(Error error, HttpStatus statusCode) {
        super(error.getMessage());
        this.error = error;
        this.statusCode = statusCode.value();
    }
}
