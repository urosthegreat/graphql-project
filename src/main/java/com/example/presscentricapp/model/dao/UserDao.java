/**
 * This class represents a data transfer object (DTO) for user information in the PressCentric application.
 */
package com.example.presscentricapp.model.dao;

import lombok.Data;

/**
 * A data transfer object (DTO) representing user information.
 */
@Data
public class UserDao {

    /**
     * The unique identifier for the user.
     */
    private Integer id;

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's email address.
     */
    private String email;
}
