package com.timzowen.company.service.impl;

import com.timzowen.company.exceptions.ResourceNotFoundException;
import com.timzowen.company.model.Employee;
import com.timzowen.company.repository.EmployeeRepository;
import com.timzowen.company.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("%s Not found","id",id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("%s Not Found","id",id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee1.getLastName());
        employee1.setEmail(employee.getEmail());
        employeeRepository.save(employee1);
        return employee1;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }


}
