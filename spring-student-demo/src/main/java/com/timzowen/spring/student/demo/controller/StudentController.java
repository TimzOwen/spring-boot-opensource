package com.timzowen.spring.student.demo.controller;

import com.timzowen.spring.student.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("student",studentService.getAllStudents());
        return "index";
    }

}
