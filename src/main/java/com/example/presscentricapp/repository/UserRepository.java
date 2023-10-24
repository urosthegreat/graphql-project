/**
 * This repository interface provides access to user data in the database.
 */
package com.example.presscentricapp.repository;

import com.example.presscentricapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A repository for managing user entities in the database.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * Finds a user entity by their email address.
     *
     * @param email The email address of the user to be found.
     * @return An optional user entity if found, or an empty optional if not found.
     */
    Optional<UserEntity> findByEmail(String email);
}
