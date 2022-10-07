package com.timzowen.springProductRecap1.repository;

import com.timzowen.springProductRecap1.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
