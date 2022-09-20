package com.microservice.orderservice.service;

import com.microservice.orderservice.domain.document.Address;
import com.microservice.orderservice.domain.document.Order;
import com.microservice.orderservice.domain.repository.AddressRepository;
import com.microservice.orderservice.domain.repository.OrderRepository;
import com.microservice.orderservice.domain.repository.PaymentDetailRepository;
import com.microservice.orderservice.domain.request.CreateOrderRequest;
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

    public Order createOrder(CreateOrderRequest request) {
        Address billingAddress = Address.builder()
                .city(request.getBillingAddress().getCity())
                .country(request.getBillingAddress().getCountry())
                .line(request.getBillingAddress().getLine())
                .postcode(request.getBillingAddress().getPostcode())
                .build();
        billingAddress = addressRepository.save(billingAddress);

        Address shippingAddress = Address.builder()
                .city(request.getShippingAddress().getCity())
                .country(request.getShippingAddress().getCountry())
                .line(request.getShippingAddress().getLine())
                .postcode(request.getShippingAddress().getPostcode())
                .build();
        shippingAddress = addressRepository.save(shippingAddress);

        return null;
    }
}
