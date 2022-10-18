package com.timzowen.employees.service;

import com.timzowen.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

}
