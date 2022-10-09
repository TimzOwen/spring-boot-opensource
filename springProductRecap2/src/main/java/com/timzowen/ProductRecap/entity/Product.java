package com.timzowen.ProductRecap.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products",
    schema = "productRecap2")
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_gen"
    )
    @SequenceGenerator(
            name = "seq_gen",
            sequenceName = "product_seq_gen",
            allocationSize = 1
    )
    private Long Id;
    private String name;
    private String location;
    private BigDecimal cost;
    private String manufacturer;
}
