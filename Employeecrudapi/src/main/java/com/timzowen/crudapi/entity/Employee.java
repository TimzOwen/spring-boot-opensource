package com.timzowen.crudapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "employees")
@Table(name = "employees",schema = "employeesRest")
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_gen")
    @SequenceGenerator(
            name = "employee_gen",
            sequenceName = "employee_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String rank;
    private int salary;
}
