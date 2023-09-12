package com.timzowen.reactive.service;

import com.timzowen.reactive.student.Student;
import reactor.core.publisher.Flux;

public interface StudentService {

    Flux<Student> getAllStudents();
}
