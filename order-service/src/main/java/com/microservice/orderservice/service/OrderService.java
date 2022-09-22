package com.microservice.orderservice.service;

import com.microservice.orderservice.domain.clients.FinanceServiceClient;
import com.microservice.orderservice.domain.document.Address;
import com.microservice.orderservice.domain.document.Order;
import com.microservice.orderservice.domain.document.PaymentDetail;
import com.microservice.orderservice.domain.exception.ServiceException;
import com.microservice.orderservice.domain.repository.AddressRepository;
import com.microservice.orderservice.domain.repository.OrderRepository;
import com.microservice.orderservice.domain.repository.PaymentDetailRepository;
import com.microservice.orderservice.domain.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    private FinanceServiceClient financeServiceClient;

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

        PaymentDetail paymentDetail = PaymentDetail.builder()
                .cardType(request.getPaymentDetails().getCardType())
                .cardNumber(request.getPaymentDetails().getCardNumber())
                .holderName(request.getPaymentDetails().getHolderName())
                .cvv(request.getPaymentDetails().getCvv())
                .expire(request.getPaymentDetails().getExpire())
                .customerId(request.getPaymentDetails().getCustomerId())
                .createdDate(new Date())
                .build();
        paymentDetail = paymentDetailRepository.save(paymentDetail);

        Order order = Order.builder()
                .amount(request.getAmount())
                .customerId(request.getCustomerId())
                .quantity(request.getQuantity())
                .status(request.getStatus())
                .productId(request.getProductId())
                .billingAddress(billingAddress)
                .shippingAddress(shippingAddress)
                .paymentDetails(paymentDetail)
                .createdDate(new Date())
                .build();
        return orderRepository.save(order);
    }
    public void processPayment(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.name(), "Order not exist", null);
        }
        try {
            financeServiceClient.sendPaymentProcessingEvent(order.get());
        }catch (Exception e) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.name(), "Process payment failure" , null);
        }
    }

    @Transactional
    public void updateStatus(Long orderId, String status) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.name(), "Order not exist", null);
        }
        order.get().setStatus(status);
        orderRepository.save(order.get());
    }
}
