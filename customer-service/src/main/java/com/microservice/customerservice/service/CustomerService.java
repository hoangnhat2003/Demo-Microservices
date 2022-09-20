package com.microservice.customerservice.service;

import com.microservice.customerservice.domain.document.Customer;
import com.microservice.customerservice.domain.repository.CustomerRepository;
import com.microservice.customerservice.domain.request.CreateCustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .address(request.getAddress())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();
      return customerRepository.save(customer);
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).get();
    }
}
