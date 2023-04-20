package com.timzowen.company.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Server {

    @Id
    @GeneratedValue
    private long id;
    private String serverName;
    private int serverCost;

}
