package com.microservice.orderservice.controller;

import com.microservice.orderservice.domain.document.Order;
import com.microservice.orderservice.domain.request.CreateOrderRequest;
import com.microservice.orderservice.domain.response.ApiResponse;
import com.microservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        Order data = orderService.createOrder(request);
        return new ApiResponse(HttpStatus.OK.value(), "Create order successfully",data.getId());
    }

}
