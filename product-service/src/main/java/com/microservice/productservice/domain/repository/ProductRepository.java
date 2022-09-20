package com.microservice.productservice.domain.repository;

import com.microservice.productservice.domain.document.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
