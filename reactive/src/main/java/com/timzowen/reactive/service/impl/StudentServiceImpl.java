package com.timzowen.reactive.service.impl;

import com.timzowen.reactive.repository.StudentRepository;
import com.timzowen.reactive.service.StudentService;
import com.timzowen.reactive.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
