package com.timzowen.springsecurity.web;

import com.timzowen.springsecurity.service.impl.UserServiceImpl;
import com.timzowen.springsecurity.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserServiceImpl userService;

    public UserRegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistration(){
        return "registration";
    }
    @PostMapping
    public String saveUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
