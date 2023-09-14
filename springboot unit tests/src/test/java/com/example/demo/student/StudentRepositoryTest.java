package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository repositoryTest;

    @AfterEach
    void tearDown(){
        repositoryTest.deleteAll();
    }

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

    @Test
    void selectedStudentEmailDoesNotExist(){
        String email = "owen@gmail.com";
        boolean expectedEmail = repositoryTest.selectExistsEmail(email);
        assertThat(expectedEmail).isFalse();
    }
}