package com.timzowen.reactive.service;

import com.timzowen.reactive.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> getAllStudents();

    Mono<Student>  findStudentById(Integer id);

    Mono<Student> saveStudent(Student student);
}
