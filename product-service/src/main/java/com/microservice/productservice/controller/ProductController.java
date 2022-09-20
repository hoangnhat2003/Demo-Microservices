package com.microservice.productservice.controller;

import com.microservice.productservice.domain.document.Product;
import com.microservice.productservice.domain.request.CreateProductRequest;
import com.microservice.productservice.domain.response.ApiResponse;
import com.microservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Product data = productService.getById(id);
        return new ApiResponse(HttpStatus.OK.value(), null,data);
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody CreateProductRequest product) {
        Product data = productService.addProduct(product);
        return new ApiResponse(HttpStatus.OK.value(), "Create new product successfully",data);
    }
}
