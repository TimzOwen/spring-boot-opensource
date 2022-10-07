package com.timzowen.springProductRecap1.repository;

import com.timzowen.springProductRecap1.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void deleteByIdMethod(){
         Long id = 5L;
        shopRepository.deleteById(id);
    }

    @Test
    void saveMethod(){

        Shop shop = new Shop();
        shop.setShopName("Jumia");
        shop.setInStock(true);
        shop.setLocation("Online");
        shop.setStockValue(new BigDecimal("300000.50"));

        shopRepository.save(shop);
    }

    @Test
    void deleteAllMethod(){
        shopRepository.deleteAll();
    }

    @Test
    void updateMethod(){
        Long id = 6L;
        Shop shop = shopRepository.findById(id).get();
        shop.setShopName("Uber Eats");
        shop.setLocation("Mombasa");
        shopRepository.save(shop);
    }

    @Test
    void getAllShops(){
        List<Shop> allShops = shopRepository.findAll();
        allShops.forEach((shops) ->{
            System.out.println(shops.getLocation());
        });
    }

    @Test
    void countMethod(){
        System.out.println(shopRepository.count());
    }

    @Test
    void saveAllMethod(){

        Shop shop = new Shop();
        shop.setShopName("Jumia");
        shop.setInStock(false);
        shop.setLocation("Eldoret");
        shop.setStockValue(new BigDecimal("300000.50"));

        Shop shop1 = new Shop();
        shop1.setShopName("Alibaba");
        shop1.setInStock(true);
        shop1.setLocation("Nairobi");
        shop1.setStockValue(new BigDecimal("300000.50"));

        Shop shop2 = new Shop();
        shop2.setShopName("Amazon");
        shop2.setInStock(false);
        shop2.setLocation("USA");
        shop2.setStockValue(new BigDecimal("300000.50"));

        Shop shop3 = new Shop();
        shop3.setShopName("Twiga food");
        shop3.setInStock(true);
        shop3.setLocation("Nakuru");
        shop3.setStockValue(new BigDecimal("300000.50"));

        shopRepository.saveAll(List.of(shop,shop1,shop2,shop3));
    }

}