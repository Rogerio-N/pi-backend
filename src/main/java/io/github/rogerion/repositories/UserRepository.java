package io.github.rogerion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("SELECT u FROM User u where u.email = ?1")
    User findByEmail(String email);

}
