package com.microservice.orderservice.domain.model;

import lombok.Data;

@Data
public class PaymentDetailForm {
    private Long customerId;
    private String cardType;
    private String holderName;
    private String cardNumber;
    private Integer cvv;
    private String expire;
}
