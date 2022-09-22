package com.microservice.financeservice.controller;

import com.microservice.financeservice.domain.request.PaymentEventRequest;
import com.microservice.financeservice.domain.response.ApiResponse;
import com.microservice.financeservice.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping("/confirmPayment")
    public ResponseEntity<?> confirmPayment(@RequestBody PaymentEventRequest request) throws Exception {
        financeService.confirmPayment(request.getOrderId());
        return new ApiResponse(HttpStatus.OK.value(), "Confirm payment successfully",request.getOrderId());
    }

    @PostMapping("/rejectPayment")
    public ResponseEntity<?> rejectPayment(@RequestBody PaymentEventRequest request) throws Exception {
        financeService.rejectPayment(request.getOrderId());
        return new ApiResponse(HttpStatus.OK.value(), "Reject payment successfully",request.getOrderId());
    }
}
