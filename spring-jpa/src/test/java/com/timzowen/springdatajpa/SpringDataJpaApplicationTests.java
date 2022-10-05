package com.timzowen.springdatajpa;

import com.timzowen.springdatajpa.entity.Product;
import com.timzowen.springdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class SpringDataJpaApplicationTests {

	// create injection of the repository class
	@Autowired
	private ProductRepository productRepository;

	@Test
	void saveMethod() {

		//create object of the Entity
		Product product = new Product();
		product.setName("Sofa set");
		product.setImageUrl("sofaset.png");
		product.setSku("ABED1015");
		product.setDescription("Warm office set up sofa");
		product.setActive(false);
		product.setPrice(new BigDecimal("10000.50"));

		//save the produce
		Product savedProduct = productRepository.save(product);

		//Display the product
		System.out.println(savedProduct.getId());
		System.out.println(savedProduct.toString());

	}

}
