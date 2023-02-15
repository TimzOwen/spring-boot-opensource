package com.timzowen.CRUD.postgress.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @Autowired
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getCustomer();
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping("{studentId}")
    public void deleteCustomer(@PathVariable Long studentId){
        customerService.deleteCustomer(studentId);
    }
    @PutMapping("{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        customerService.updateCustomer(customerId,name,email);
    }


}
