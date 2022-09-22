package com.microservice.orderservice.config.kafka;

public class KafkaConfig {
    public static final String ORDER_STOCK_CONFIRM_TOPIC = "order.stock.confirm";
    public static final String ORDER_STOCK_REJECT_TOPIC = "order.stock.reject";

    public static final String FINANCE_PAYMENT_PROCESS_TOPIC = "finance.payment.process";
    public static final String ORDER_PAYMENT_CONFIRM_TOPIC = "order.payment.confirm";
    public static final String ORDER_PAYMENT_REJECT_TOPIC = "order.payment.reject";
}
