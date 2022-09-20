package com.microservice.orderservice.domain.repository;

import com.microservice.orderservice.domain.document.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
