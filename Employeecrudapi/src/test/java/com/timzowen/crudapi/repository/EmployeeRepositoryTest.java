package com.timzowen.crudapi.repository;

import com.timzowen.crudapi.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void addEmployee(){
        Employee employee = new Employee();
        employee.setName("Timo");
        employee.setRank("junior");
        employee.setSalary(120000);
        employeeRepository.save(employee);
    }

    @Test
    void addMultipleEmployee(){
        Employee employee = new Employee();
        employee.setName("Owen");
        employee.setRank("junior");
        employee.setSalary(100000);

        Employee employee1 = new Employee();
        employee1.setName("Maddie");
        employee1.setRank("Entry Level");
        employee1.setSalary(80000);

        Employee employee2 = new Employee();
        employee2.setName("Somoo");
        employee2.setRank("Senior");
        employee2.setSalary(3000000);

        Employee employee3 = new Employee();
        employee3.setName("Shem");
        employee3.setRank("Expert");
        employee3.setSalary(9000000);

        employeeRepository.saveAll(List.of(employee,employee1,employee2,employee3));
    }

    @Test
    void findAllEmployees(){
        employeeRepository.findAll();
    }

    @Test
    void updateEmployee(){
        Long id = 1L;
        Employee employee = employeeRepository.findById(id).get();
        employee.setRank("senior");
        employee.setSalary(520000);
        employeeRepository.save(employee);
    }

    @Test
    void getEmployee(){
        Long id = 1L;
        Employee employee = employeeRepository.findById(id).get();
        System.out.println(employee);
    }

    @Test
    void deleteEmployee(){
        Long id = 1L;
        employeeRepository.deleteById(id);
    }

    @Test
    void deleteEmployees(){
        employeeRepository.deleteAll();
    }

}