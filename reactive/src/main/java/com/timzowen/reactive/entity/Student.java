package com.timzowen.reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("students")
public class Student {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
}
