package com.timzowen.springsecurity.web;

import com.timzowen.springsecurity.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserServiceImpl userService;


    public UserRegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }
}
