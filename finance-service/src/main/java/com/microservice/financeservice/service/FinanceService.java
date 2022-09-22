package com.microservice.financeservice.service;

import com.microservice.financeservice.domain.clients.OrderServiceClient;
import com.microservice.financeservice.domain.document.Invoice;
import com.microservice.financeservice.domain.document.Order;
import com.microservice.financeservice.domain.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class FinanceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrderServiceClient orderServiceClient;

    public void createInvoice(Order order) {
        Invoice invoice = Invoice.builder()
                .orderId(order.getId())
                .productId(order.getProductId())
                .customerId(order.getCustomerId())
                .paymentDetailId(order.getPaymentDetails().getId())
                .billingAddressId(order.getBillingAddress().getId())
                .totalChargeAmount(order.getAmount())
                .productPrice(order.getProductPrice())
                .quantity(order.getQuantity())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();
         invoiceRepository.save(invoice);
    }

    public void rejectPayment(Long orderId) throws Exception {
        orderServiceClient.sendPaymentProcessingFailure(orderId);
    }

    public void confirmPayment(Long orderId) throws Exception {
        orderServiceClient.sendPaymentProcessingSuccess(orderId);
    }

}
