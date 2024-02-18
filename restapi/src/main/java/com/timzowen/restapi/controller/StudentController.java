package com.timzowen.restapi.controller;

import com.timzowen.restapi.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students/api/v1/")
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        return new Student(3,"Timz","owen");
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(4,"Timz","Owen"));
        students.add(new Student(4,"Timz","Owen"));
        students.add(new Student(4,"Timz","Owen"));
        return ResponseEntity.ok(students);
    }

    // using @PathVariable
    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentPathVariable(@PathVariable("id") int studentId){
        Student student = new  Student(studentId, "Timz","owen");
        return ResponseEntity.ok(student);
    }

    // using Request Param
    @GetMapping("query")
    public ResponseEntity<Student> getStudentRequestParam(@RequestParam int studentId){
        Student student = new Student(studentId,"Timz","Owen");
        return ResponseEntity.ok(student);

    }
    // using Request Param to handle multiple params
    @GetMapping("query/params")
    public ResponseEntity<Student> getStudentRequestParamQuery(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
         Student student =  new Student(studentId,firstName,lastName);
         return ResponseEntity.ok(student);
    }

    // POST
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    // update mapping
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId,
                                 @RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // delete mapping
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok("student with Id: " + id + " deleted successfully");
    }
}
