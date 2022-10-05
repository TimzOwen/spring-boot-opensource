package com.timzowen.springdatajparecap.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Bank {
    @Id
    private int id;
    private String name;
    private String location;
    private int employees;
    private BigDecimal netWorth;
}
