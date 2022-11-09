package com.timzowen.spring.student.demo.service.impl;

import com.timzowen.spring.student.demo.model.Student;
import com.timzowen.spring.student.demo.repository.StudentRepository;
import com.timzowen.spring.student.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student savStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).get();
    }
}
