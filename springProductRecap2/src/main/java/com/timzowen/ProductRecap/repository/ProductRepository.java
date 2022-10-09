package com.timzowen.ProductRecap.repository;

import com.timzowen.ProductRecap.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
