/**
 * This class represents a user entity in the PressCentric application.
 */
package com.example.presscentricapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * An entity class representing user data stored in the database.
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    /**
     * The user's name.
     */
    @Column(name = "name")
    private String name;

    /**
     * The user's email address.
     */
    @Column(name = "email")
    private String email;
}
