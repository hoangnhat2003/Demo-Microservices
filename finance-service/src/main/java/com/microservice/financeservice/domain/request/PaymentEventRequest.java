package com.microservice.financeservice.domain.request;

import lombok.Data;

@Data
public class PaymentEventRequest {
    private Long orderId;
}
