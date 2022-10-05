package com.timzowen.springdatajpa.repository;

import com.timzowen.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testProduct() {

        Product product = new Product();
        product.setName("dinning table");
        product.setDescription("7 seater table");
        product.setPrice(new BigDecimal("1200340.8247"));
        product.setImageUrl("image.png");
        product.setActive(true);

        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateSaveMethod(){
        Long id = 5L;
        Product product = productRepository.findById(id).get();
        product.setSku("BBJ67");

        productRepository.save(product);

        System.out.println(product.getName());
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((x)->{
            System.out.println(x.getName());
        });
    }

    @Test
    void getAnEntity(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){

        Product product = new Product();
        product.setName("Blackboard");
        product.setDescription("Teachher table");
        product.setPrice(new BigDecimal("3002.40"));
        product.setImageUrl("blackboard.png");
        product.setActive(false);

        Product product1 = new Product();
        product1.setName("Mac PC");
        product1.setDescription("Super powerful");
        product1.setPrice(new BigDecimal("121221.12"));
        product1.setImageUrl("macM1.png");
        product1.setActive(true);

        Product product2 = new Product();
        product2.setName("Boeing 787");
        product2.setDescription("350 passenger career");
        product2.setPrice(new BigDecimal("7000.50"));
        product2.setImageUrl("being.png");
        product2.setActive(false);

        productRepository.saveAll(List.of(product,product1,product2));

    }
}