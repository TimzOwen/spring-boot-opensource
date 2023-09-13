package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StudentRepositoryTest {

    @Autowired
    private  StudentRepository repositoryTest;

    @Test
    void selectStudentEmailExists() {
        Student newStudent = new Student(
                "Timz",
                "timzowen@gmail.com",
                Gender.MALE
        );
        repositoryTest.save(newStudent);
        boolean expectedEmail = repositoryTest.selectExistsEmail("timzowen@gmail.com");
        assertThat(expectedEmail).isTrue();
    }
}