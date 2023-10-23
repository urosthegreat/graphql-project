package com.example.presscentricapp.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserInput {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
}
