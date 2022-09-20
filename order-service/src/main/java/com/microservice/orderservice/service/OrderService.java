package com.microservice.orderservice.service;

import com.microservice.orderservice.domain.repository.AddressRepository;
import com.microservice.orderservice.domain.repository.OrderRepository;
import com.microservice.orderservice.domain.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;
}
