package com.timzowen.company.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_location")
    private String location;
    @Column(name = "net_worth")
    private int netWorth;

}
