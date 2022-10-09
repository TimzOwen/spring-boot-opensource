package com.timzowen.ProductRecap.repository;

import com.timzowen.ProductRecap.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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
    @Test
    void saveAllMethod(){

        Product product = new Product();
        product.setName("Table");
        product.setLocation("Eldoret");
        product.setManufacturer("Mahogany");
        product.setCost(new BigDecimal("12000.500"));

        Product product1 = new Product();
        product1.setName("Tri-circle");
        product1.setLocation("Nairobi");
        product1.setManufacturer("Tools Co");
        product1.setCost(new BigDecimal("609383.500"));

        Product product2 = new Product();
        product2.setName("Speakers");
        product2.setLocation("Embu");
        product2.setManufacturer("Sony");
        product2.setCost(new BigDecimal("883456.500"));

        productRepository.saveAll(List.of(product,product1,product2));

    }

}