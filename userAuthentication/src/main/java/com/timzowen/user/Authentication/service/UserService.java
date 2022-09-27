package com.timzowen.user.Authentication.service;

import com.timzowen.user.Authentication.model.User;
import com.timzowen.user.Authentication.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
