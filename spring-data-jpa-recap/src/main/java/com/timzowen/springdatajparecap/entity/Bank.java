package com.timzowen.springdatajparecap.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "banks_gen"
    )
    @SequenceGenerator(
            name = "banks_gen",
            sequenceName = "banks_seq_gen",
            allocationSize = 1
    )

    private int id;
    @Column(name = "bank_name")
    private String name;
    @Column(name = "bank_location")
    private String location;
    @Column(name = "total_employees")
    private int employees;
    @Column(name = "bank_net_worth")
    private BigDecimal netWorth;
}
