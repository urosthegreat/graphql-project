/**
 * This class represents input data for creating a user in the PressCentric application.
 */
package com.example.presscentricapp.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

/**
 * An input data class representing the information required to create a new user.
 */
@Data
@Getter
public class CreateUserInput {

    /**
     * The user's name.
     */
    @NotBlank
    private String name;

    /**
     * The user's email address. Must be a valid email format.
     */
    @Email(message ="Invalid email")
    @NotBlank
    private String email;
}
