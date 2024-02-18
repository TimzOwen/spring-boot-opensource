package com.timzowen.restapi.controller;

import com.timzowen.restapi.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        return new Student(3,"Timz","owen");
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(4,"Timz","Owen"));
        students.add(new Student(4,"Timz","Owen"));
        students.add(new Student(4,"Timz","Owen"));
        return students;
    }

    // using @PathVariable
    @GetMapping("student/{id}")
    public Student getStudentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Timz","owen");
    }

    // using Request Param
    @GetMapping("student/query")
    public Student getStudentRequestParam(@RequestParam int studentId){
        return new Student(studentId,"Timz","Owen");

    }
    // using Request Param to handle multiple params
    @GetMapping("student/query/params")
    public Student getStudentRequestParamQuery(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(studentId,firstName,lastName);
    }
}
