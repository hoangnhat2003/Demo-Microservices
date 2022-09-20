package com.microservice.customerservice.controller;

import com.microservice.customerservice.domain.document.Customer;
import com.microservice.customerservice.domain.request.CreateCustomerRequest;
import com.microservice.customerservice.domain.response.ApiResponse;
import com.microservice.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CreateCustomerRequest request){
        Customer data = customerService.saveCustomer(request);
        return new ApiResponse(HttpStatus.OK.value(), "Save customer successfully",data.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Long id){
        Customer data = customerService.getById(id);
        return new ApiResponse(HttpStatus.OK.value(), null,data);
    }
}
