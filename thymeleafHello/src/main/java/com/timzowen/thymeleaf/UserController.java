package com.timzowen.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/if-unless")
    public String ifUnless(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("Timz","timz@gmail.com","ADMIN"));
        users.add(new User("Owen","owen@gmail.com","DEVELOPER"));
        users.add(new User("kim","kim@gmail.com","HR"));
        users.add(new User("Ryna","okiri@gmail.com","ADMIN"));
        users.add(new User("James","nandwa@gmail.com","DEVELOPER"));
        users.add(new User("babu","owino@gmail.com","Relations"));
        model.addAttribute("users",users);
        return "if-unless";
    }

    // switch case
    @GetMapping("/switch-case")
    public String switchExample(Model model){
        User user = new User("Shem","timz@gmail.com","TESTER");
        model.addAttribute("user",user);
        return "switch-Example";
    }

}
