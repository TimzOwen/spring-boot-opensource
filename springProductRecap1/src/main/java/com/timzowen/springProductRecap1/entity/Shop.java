package com.timzowen.springProductRecap1.entity;


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
@Table(name = "shops", schema ="productRecap1" )
public class Shop {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shop_gen"
        )
    @SequenceGenerator(
            name="shop_gen",
            sequenceName = "shop_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "Shop_name")
    private String shopName;
    private String location;
    private boolean inStock;
    private BigDecimal stockValue;
}
