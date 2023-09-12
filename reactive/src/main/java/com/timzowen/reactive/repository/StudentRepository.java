package com.timzowen.reactive.repository;

import com.timzowen.reactive.student.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    // find student by firstName
    Flux<Student> findAllByFirstNameIgnoreCase(String firstName);
}
