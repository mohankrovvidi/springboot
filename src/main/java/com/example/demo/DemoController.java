package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DemoController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return " Customer added successfully";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

     @GetMapping("/find")
     public Customer findCustomerById(@RequestParam Integer id){
        return customerRepository.findById(id).get();

    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello Mr  %s!", name);
    }


}
