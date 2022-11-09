package com.timzowen.spring.student.demo.controller;

import com.timzowen.spring.student.demo.model.Student;
import com.timzowen.spring.student.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("student/new")
    public String saveStudent(Model model){
        Student student = new Student();
        model.addAttribute(student);
        return "save_student";
    }

    @GetMapping("student/edit/{/id}")
    public String editStudent(@PathVariable("id") Long id,
                              Model model){
        model.addAttribute("student",studentService.getStudentByID(id));
        return "edit_student";

    }

}
