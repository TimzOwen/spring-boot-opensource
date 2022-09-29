package com.timzowen.user.Authentication.service;

import com.timzowen.user.Authentication.model.Role;
import com.timzowen.user.Authentication.model.User;
import com.timzowen.user.Authentication.repository.UserRepository;
import com.timzowen.user.Authentication.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword(),
                Collections.singletonList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
