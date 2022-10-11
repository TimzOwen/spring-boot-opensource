package com.timzowen.ecommercecurapi.contoller;

import com.timzowen.ecommercecurapi.model.Employee;
import com.timzowen.ecommercecurapi.repository.EmployeeRepository;
import com.timzowen.ecommercecurapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // Build Create Employee REST
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employee API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }

    // get employee by ID API
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long employeeId){
        return new ResponseEntity<>(employeeService.getEmployee(employeeId),HttpStatus.OK);
    }

   // build update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
    }

    // Delete employee Rest API.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
    }

}
