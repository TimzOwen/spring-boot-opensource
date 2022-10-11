package com.timzowen.ecommercecurapi.service.impl;

import com.timzowen.ecommercecurapi.model.Employee;
import com.timzowen.ecommercecurapi.repository.EmployeeRepository;
import com.timzowen.ecommercecurapi.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
