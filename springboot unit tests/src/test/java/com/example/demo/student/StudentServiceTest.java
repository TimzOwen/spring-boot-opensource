package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    private StudentService serviceTest;

    @BeforeEach
    void setUp(){
        serviceTest = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        serviceTest.getAllStudents();
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        Student student = new Student("Timz","timz@gmail.com",Gender.MALE);
        serviceTest.addStudent(student);
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void throwWhenEmailIsTaken(){
        Student student = new Student("Timz","timzowen@gmail.com",Gender.MALE);
        given(studentRepository.selectExistsEmail(student.getEmail()))
                .willReturn(true);
        assertThatThrownBy(()->serviceTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");
        verify(studentRepository, never()).save(student);
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}