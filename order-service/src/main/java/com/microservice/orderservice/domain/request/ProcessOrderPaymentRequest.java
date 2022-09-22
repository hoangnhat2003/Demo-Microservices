package com.microservice.orderservice.domain.request;

import lombok.Data;

@Data
public class ProcessOrderPaymentRequest {
    private Long orderId;
}
