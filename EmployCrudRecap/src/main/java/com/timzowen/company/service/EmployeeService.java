package com.timzowen.company.service;

import com.timzowen.company.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);

}
