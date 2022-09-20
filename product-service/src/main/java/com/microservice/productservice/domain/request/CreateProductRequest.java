package com.microservice.productservice.domain.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String productName;
    private String description;
    private Double price;
    private Integer quantityInStock;
    private Integer categoryId;
}
