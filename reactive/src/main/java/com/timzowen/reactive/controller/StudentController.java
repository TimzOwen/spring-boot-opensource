package com.timzowen.reactive.controller;

import com.timzowen.reactive.entity.Student;
import com.timzowen.reactive.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public Mono<Student> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudent(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/allStudents")
    public Flux<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
