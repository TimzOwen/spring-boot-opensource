package com.timzowen.company.service;

import com.timzowen.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);



}
