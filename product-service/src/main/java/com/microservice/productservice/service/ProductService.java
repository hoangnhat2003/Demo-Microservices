package com.microservice.productservice.service;

import com.microservice.productservice.domain.document.Product;
import com.microservice.productservice.domain.repository.ProductRepository;
import com.microservice.productservice.domain.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(CreateProductRequest request) {
        Product product = Product.builder()
                .productName(request.getProductName())
                .description(request.getDescription())
                .price(request.getPrice())
                .categoryId(request.getCategoryId())
                .quantityInStock(request.getQuantityInStock())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
