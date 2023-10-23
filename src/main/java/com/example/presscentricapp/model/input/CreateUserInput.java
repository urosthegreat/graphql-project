package com.example.presscentricapp.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class CreateUserInput {
    @NotBlank
    private String name;
    @Email(message ="Invalid email")
    @NotBlank
    private String email;
}
