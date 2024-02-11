package org.timzowen.estore.service;

import org.timzowen.estore.data.UserRepository;
import org.timzowen.estore.model.User;
import org.timzowen.estore.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    EmailVerificationService emailVerificationService;

    public UserServiceImpl(UserRepository userRepository, EmailVerificationService emailVerificationService){
        this.userRepository = userRepository;
        this.emailVerificationService=emailVerificationService;
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

        boolean isUserCreated;

        try{
            isUserCreated = userRepository.save(user);
        }catch (RuntimeException exception){
            throw new UserServiceException(exception.getMessage());
        }

        if (!isUserCreated) throw new UserServiceException("Could not create user");

        try{
            emailVerificationService.scheduleEmailVerification(user);
        }catch (RuntimeException exception){
            throw new UserServiceException(exception.getMessage());
        }

        return user;
    }

    public void testNothing(){
        System.out.println("nothing");
    }

}
