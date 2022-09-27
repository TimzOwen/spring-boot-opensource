package com.timzowen.user.Authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class UserAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

}
