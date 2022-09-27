package com.timzowen.user.Authentication.web.controller;

import com.timzowen.user.Authentication.service.UserService;
import com.timzowen.user.Authentication.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    // return page on success registration
    @GetMapping
    public String showRegistration(){
        return "Registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
