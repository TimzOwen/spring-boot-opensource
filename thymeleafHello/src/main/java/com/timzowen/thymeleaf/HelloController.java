package com.timzowen.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","Hello world Thymeleaf");
        return "helloworld";
    }

    @GetMapping("/style")
    public String thymeleafDemo(){
        return "add-css-js";
    }
}
