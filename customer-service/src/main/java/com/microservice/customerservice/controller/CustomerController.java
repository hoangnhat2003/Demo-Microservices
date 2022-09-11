package com.microservice.customerservice.controller;

import com.microservice.customerservice.domain.document.Customer;
import com.microservice.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService userService;

    @PostMapping
    public Customer saveUser(@RequestBody Customer user){
        return null;
    }
}
