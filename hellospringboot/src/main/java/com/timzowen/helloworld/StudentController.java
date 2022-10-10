package com.timzowen.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Timz","Owen");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tim","Owen"));
        students.add(new Student("James","Orengo"));
        students.add(new Student("Dismus","Onyango"));
        students.add(new Student("Kimberly","Paris"));
        students.add(new Student("Junet","Mohammed"));
        students.add(new Student("Larry","aKinyi"));
        return students;
    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student pathVarStudent(@PathVariable("firstName") String firstName,
                                  @PathVariable("lastName") String lastName){
        return new Student(firstName,lastName);
    }

    // make sure to include ? symbol and & symbol
    @GetMapping("/student/query")
    public Student studentQueryParam(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName){
        return new Student(firstName, lastName);
    }
}
