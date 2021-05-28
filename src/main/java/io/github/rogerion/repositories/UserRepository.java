package io.github.rogerion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
