package com.timzowen.spring.student.demo.repository;

import com.timzowen.spring.student.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
