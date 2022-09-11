package com.microservice.customerservice.domain.repository;

import com.microservice.customerservice.domain.document.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
