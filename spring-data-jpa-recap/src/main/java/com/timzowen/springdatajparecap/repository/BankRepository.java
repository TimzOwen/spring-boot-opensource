package com.timzowen.springdatajparecap.repository;

import com.timzowen.springdatajparecap.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
