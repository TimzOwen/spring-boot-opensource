package com.timzowen.springsecurity.repository;

import com.timzowen.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // retrieve user by email
    User findByEmail(String email);
}
