package org.timzowen.estore.service;

import org.timzowen.estore.model.User;


public interface UserService {

    User createUser(String firstName,
                    String lastName,
                    String email,
                    String password,
                    String repeatPassword);
}
