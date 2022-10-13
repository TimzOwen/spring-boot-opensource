package com.timzowen.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/iteration")
    public String bootstrap(Model model){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Timz","Owen","timzowen@gmail.com"));
        employees.add(new Employee("shem","kiptoo","shemkiptoo@gmail.com"));
        employees.add(new Employee("John","Doe","johndoe@gmail.com"));
        employees.add(new Employee("Jame","Orengo","jamesorengo@gmail.com"));
        employees.add(new Employee("Jane","rono","janerono@gmail.com"));
        model.addAttribute("employees",employees);
        return "iteration";
    }

}
