package com.microservice.orderservice.domain.constants;

public class OrderStatus {
    public static final String INITIATED_RESERVING_STOCK = "Initiated Reserving Stock";
    public static final String RESERVED_PROCESSING_PAYMENT = "Reserved Processing Payment";
    public static final String PAYED_PREPARING_FOR_SHIPMENT = "Payed Preparing For Shipment";
    public static final String CANCELLED_OUT_OF_STOCK = "Cancelled Out Of Stock";
    public static final String CANCELLED_PAYMENT_REJECTED = "Cancelled Payment Rejected";
}
