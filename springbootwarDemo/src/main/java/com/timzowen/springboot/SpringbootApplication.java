package com.timzowen.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootApplication {

	public static void main(String[] args) {

		LombokTest lombokTest = new LombokTest();
		lombokTest.setName("Lombok");
		lombokTest.setLocation("no more boiler plate");
		lombokTest.setId(129);

		System.out.println(lombokTest.getName());
		System.out.println(lombokTest.getLocation());
		System.out.println(lombokTest.getId());

		SpringApplication.run(SpringbootApplication.class, args);
	}

	@GetMapping("/test")
	public String testCheck(){
		return "Test Ok for War Deployment";
	}


	@GetMapping("/testing")
	public String testing(){
		return "Test Ok for War testing auto reaload";
	}

}
