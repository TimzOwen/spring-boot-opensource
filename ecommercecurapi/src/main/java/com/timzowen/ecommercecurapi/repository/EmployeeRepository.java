package com.timzowen.ecommercecurapi.repository;

import com.timzowen.ecommercecurapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
