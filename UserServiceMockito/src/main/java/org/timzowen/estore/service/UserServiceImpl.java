package org.timzowen.estore.service;

import org.timzowen.estore.data.UserRepository;
import org.timzowen.estore.model.User;
import org.timzowen.estore.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {

        if (firstName==null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("user's first name is empty");
        }

        if (lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("user last name should not be empty");
        }

        User user = new User(firstName,lastName,email, UUID.randomUUID().toString());

        boolean isUserCreated = userRepository.save(user);

        if (!isUserCreated) throw new UserServiceException("Could not create user");

        return user;

    }
}
