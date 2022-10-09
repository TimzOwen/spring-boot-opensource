package com.timzowen.ProductRecap.repository;

import com.timzowen.ProductRecap.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductRecap2Test {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        Product product = new Product();
        product.setName("Laptop");
        product.setLocation("Nakuru");
        product.setManufacturer("HP");
        product.setCost(new BigDecimal("67000.500"));

        productRepository.save(product);

    }

}