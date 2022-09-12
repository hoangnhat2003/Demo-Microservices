package com.microservice.customerservice.domain.repository;

import com.microservice.customerservice.domain.document.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
