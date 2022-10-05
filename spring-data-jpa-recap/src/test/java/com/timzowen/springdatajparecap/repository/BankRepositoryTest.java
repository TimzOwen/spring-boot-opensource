package com.timzowen.springdatajparecap.repository;

import com.timzowen.springdatajparecap.entity.Bank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankRepositoryTest {

    @Autowired
    private BankRepository bankRepository;

    @Test
    void testBankRepo(){

        Bank bank = new Bank();
        bank.setName("Kcb Bank");
        bank.setEmployees(300);
        bank.setLocation("Nauru");
        bank.setNetWorth(new BigDecimal("3000000.9374"));

        Bank savedBank = bankRepository.save(bank);

        System.out.println(savedBank.getId());
        System.out.println(savedBank.toString());


    }

}