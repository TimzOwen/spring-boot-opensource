package com.timzowen.springsecurity.web;

import com.timzowen.springsecurity.service.impl.UserServiceImpl;
import com.timzowen.springsecurity.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserServiceImpl userService;

    public UserRegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }
    @PostMapping
    public String saveUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
