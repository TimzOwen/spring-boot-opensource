package com.timzowen.ecommercecurapi.service.impl;

import com.timzowen.ecommercecurapi.exception.ResourceNotFound;
import com.timzowen.ecommercecurapi.model.Employee;
import com.timzowen.ecommercecurapi.repository.EmployeeRepository;
import com.timzowen.ecommercecurapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElseThrow( ()->
                new ResourceNotFound("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save the object
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id){
         employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Employee","id",id));
        employeeRepository.deleteById(id);
    }

}
