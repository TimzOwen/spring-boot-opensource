package com.timzowen.CRUD.postgress.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner (CustomerRepository customerRepository){
        return args -> {
            Customer timz = new Customer(
                    "Timz Owen",
                    "timz@gmail.com",
                    LocalDate.of(2000, Month.APRIL,7)
            );
            Customer shem = new Customer(
                    "Shem Onyango",
                    "shem@gmail.com",
                    LocalDate.of(1999, Month.JULY,2)
            );
            customerRepository.saveAll(
                    List.of(timz,shem)
            );
        };
    }

}
