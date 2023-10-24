/**
 * This class represents input data for updating a user in the PressCentric application.
 */
package com.example.presscentricapp.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * An input data class representing the information required to update an existing user.
 */
@Data
public class UpdateUserInput {

    /**
     * The updated user's name.
     */
    @NotBlank
    private String name;

    /**
     * The updated user's email address. Must be a valid email format.
     */
    @Email
    @NotBlank
    private String email;
}
