package com.timz.owen.repository;

import com.timz.owen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    // create local method to get the user email
    Optional<User> findByEmail(String email);
}
