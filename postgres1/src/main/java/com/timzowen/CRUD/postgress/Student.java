package com.timzowen.CRUD.postgress;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            sequenceName = "student_sequence",
            name = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE
    )
    long id;
    String name;
    String school;
    String email;


}
