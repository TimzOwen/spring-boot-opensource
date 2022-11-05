package com.timzowen.spring.student.demo.model;

import lombok.Data;


@Data
public class Student {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
}
