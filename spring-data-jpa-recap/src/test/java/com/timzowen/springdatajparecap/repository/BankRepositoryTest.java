package com.timzowen.springdatajparecap.repository;

import com.timzowen.springdatajparecap.entity.Bank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankRepositoryTest {

    @Autowired
    private BankRepository bankRepository;

    @Test
    void saveMethod(){

        Bank bank = new Bank();
        bank.setName("Kcb Bank");
        bank.setEmployees(300);
        bank.setLocation("Nauru");
        bank.setNetWorth(new BigDecimal("3000000.9374"));

        Bank savedBank = bankRepository.save(bank);

        System.out.println(savedBank.getId());
        System.out.println(savedBank.toString());
    }

    @Test
    void findByIdMethod(){
        int id = 1;
        System.out.println(bankRepository.findById(id));
    }

    @Test
    void saveUpdate(){
        int id = 3;
        Bank bank = bankRepository.findById(id).get();
        bank.setName("NCBA Bank");

        bankRepository.save(bank);
    }

    @Test
    void deleteByIdMethod(){
        int id = 2;
        bankRepository.deleteById(id);
    }

    @Test
    void findAllMethod(){
        List<Bank> allBanks = bankRepository.findAll();
        allBanks.forEach((b)->{
            System.out.println(b.getName());
        });
    }

    @Test
    void saveAllMethod(){
        Bank bank = new Bank();
        bank.setName("Kcb Bank");
        bank.setEmployees(300);
        bank.setLocation("Nauru");
        bank.setNetWorth(new BigDecimal("3000000.9374"));

        Bank bank1 = new Bank();
        bank1.setName("National Bank");
        bank1.setEmployees(1000);
        bank1.setLocation("Mombasa");
        bank1.setNetWorth(new BigDecimal("0987654.9374"));

        Bank bank2 = new Bank();
        bank2.setName("Equity Bank");
        bank2.setEmployees(500);
        bank2.setLocation("Eldoret");
        bank2.setNetWorth(new BigDecimal("923798237.9374"));

        Bank bank3 = new Bank();
        bank3.setName("Absa Bank");
        bank3.setEmployees(800);
        bank3.setLocation("Nairobi");
        bank3.setNetWorth(new BigDecimal("56789.9374"));

        bankRepository.saveAll(List.of(bank,bank1,bank2,bank3));
    }

    @Test
    void deleteAllMethod(){
        bankRepository.deleteAll();
    }

}