package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private AutoCloseable autoCloseable;
    private StudentService serviceTest;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        serviceTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void getAllStudents() {
        serviceTest.getAllStudents();
        verify(studentRepository).findAll();
    }

    @Test
    @Disabled
    void addStudent() {
//        serviceTest.addStudent();
//        verify(studentRepository).save();
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}