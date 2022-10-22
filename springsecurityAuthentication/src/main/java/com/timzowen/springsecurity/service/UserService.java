package com.timzowen.springsecurity.service;

import com.timzowen.springsecurity.web.dto.UserRegistrationDto;
import com.timzowen.springsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

}
