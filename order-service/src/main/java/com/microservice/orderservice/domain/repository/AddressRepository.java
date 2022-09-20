package com.microservice.orderservice.domain.repository;

import com.microservice.orderservice.domain.document.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
