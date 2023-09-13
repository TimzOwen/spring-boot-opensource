package com.timzowen.reactive.service.impl;

import com.timzowen.reactive.repository.StudentRepository;
import com.timzowen.reactive.service.StudentService;
import com.timzowen.reactive.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Flux<Student> getAllStudents() {
        return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findStudentById(Integer id){
        return studentRepository.findById(id);
    }

    @Override
    public Mono<Student> saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
