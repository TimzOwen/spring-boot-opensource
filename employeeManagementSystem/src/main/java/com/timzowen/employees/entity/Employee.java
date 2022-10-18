package com.timzowen.employees.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String firstName, String lastName, String email) {
        super();
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public Employee(){}
}
