package com.timzowen.springdatajpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "stock_unit",
                        columnNames = "sku"
                ),
                @UniqueConstraint(name = "products_prices",
                        columnNames = "price")
        })
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_gen"
    )
    @SequenceGenerator(
            name = "product_gen",
            sequenceName = "product_seq_name",
            allocationSize = 2
    )
    private Long id;
    private String sku;
    @Column(name = "product_name")
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
