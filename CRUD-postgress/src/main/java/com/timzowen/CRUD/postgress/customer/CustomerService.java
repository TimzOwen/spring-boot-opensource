package com.timzowen.CRUD.postgress.customer;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer(){
      return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()){
            throw new IllegalArgumentException("Email Taken");
        }else {
            customerRepository.save(customer);
        }
    }

    public void deleteCustomer(Long studentId) {
        boolean exists = customerRepository.existsById(studentId);
        if (!exists){
            throw new IllegalArgumentException("No such user with id: " + studentId);
        }
        customerRepository.deleteById(studentId);
    }
    @Transactional
    public void updateCustomer(Long customerId, String name, String email) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->
                new IllegalArgumentException("No such customer with id: " + customerId));
        if (name != null && name.length()>0 && !Objects.equals(customer.getName(), name)){
            customer.setName(name);
        }
        if (email!=null && email.length()>0 && !Objects.equals(customer.getEmail(),email)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()){
                throw new IllegalArgumentException("Email taken");
            }
            customer.setEmail(email);
        }
    }
}
