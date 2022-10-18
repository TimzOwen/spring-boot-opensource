package com.timzowen.employees.controller;

import com.timzowen.employees.entity.Employee;
import com.timzowen.employees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.model.IModel;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String allEmployees(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employee/new")
    public String AddNewStaff(Model model){
        Employee employee = new Employee();
        model.addAttribute(employee);
        return "add_employee";
    }

    @PostMapping("/employees")
    public String saveStaff(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

}
