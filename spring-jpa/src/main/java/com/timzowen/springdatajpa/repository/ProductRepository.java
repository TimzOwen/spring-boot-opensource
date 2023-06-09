package com.timzowen.springdatajpa.repository;

import com.timzowen.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
