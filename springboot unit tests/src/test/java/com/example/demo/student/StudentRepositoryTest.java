package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
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

    void selectedStudentEmailDoesNotExist(){
        String email = "owen@gmail.com";
        boolean expectedEmail = repositoryTest.selectExistsEmail(email);
        assertThat(expectedEmail).isFalse();
    }
}