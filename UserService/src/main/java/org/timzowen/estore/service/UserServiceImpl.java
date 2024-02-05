package org.timzowen.estore.service;

import org.timzowen.estore.model.User;
import org.timzowen.estore.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String repeatPassword) {

        return new User();

    }
}
