package com.timzowen.springsecurity.service;

import com.timzowen.springsecurity.web.dto.UserRegistrationDto;
import com.timzowen.springsecurity.model.User;

public interface UserService {

    User save(UserRegistrationDto registrationDto);

}
