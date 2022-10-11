package com.timzowen.ecommercecurapi.service.impl;

import com.timzowen.ecommercecurapi.exception.ResourceNotFound;
import com.timzowen.ecommercecurapi.model.Employee;
import com.timzowen.ecommercecurapi.repository.EmployeeRepository;
import com.timzowen.ecommercecurapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {

        // using lambda
        return employeeRepository.findById(id).orElseThrow( ()->
                new ResourceNotFound("Employee","Id",id));

            // Or use if else

//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//            return employee.get();
//        }else {
//            throw  new ResourceNotFound("Employee","Id",id);
//        }


    }


}
