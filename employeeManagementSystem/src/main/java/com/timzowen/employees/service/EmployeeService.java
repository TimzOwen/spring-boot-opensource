package com.timzowen.employees.service;

import com.timzowen.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

}
