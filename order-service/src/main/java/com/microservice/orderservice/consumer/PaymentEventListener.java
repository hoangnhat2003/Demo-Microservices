package com.microservice.orderservice.consumer;

import com.microservice.orderservice.config.kafka.KafkaConfig;
import com.microservice.orderservice.domain.model.PaymentConfirmationEvent;
import com.microservice.orderservice.domain.model.PaymentRejectionEvent;
import com.microservice.orderservice.domain.utils.LoggerUtil;
import com.microservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.microservice.orderservice.domain.constants.OrderStatus.CANCELLED_PAYMENT_REJECTED;
import static com.microservice.orderservice.domain.constants.OrderStatus.PAYED_PREPARING_FOR_SHIPMENT;

@Component
public class PaymentEventListener {
    private static final String TAG = PaymentEventListener.class.getSimpleName();

    @Autowired
    private OrderService orderService;

    @KafkaListener(topicPartitions = {@TopicPartition(topic = KafkaConfig.ORDER_PAYMENT_CONFIRM_TOPIC, partitions = "0")
    })
    public void confirmPayment(@Payload PaymentConfirmationEvent dataFromTopic) {
        try {
            LoggerUtil.i(TAG, String.format("Data from topic: {} " + dataFromTopic));
            orderService.updateStatus(dataFromTopic.getOrderId(),PAYED_PREPARING_FOR_SHIPMENT);
            LoggerUtil.i(TAG, String.format("Process data from topic: {}", dataFromTopic));
        } catch (Exception e) {
            LoggerUtil.exception(TAG, e);
        }
    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = KafkaConfig.ORDER_PAYMENT_REJECT_TOPIC, partitions = "0")
    })
    public void rejectPayment(@Payload PaymentRejectionEvent dataFromTopic) {
        try {
            LoggerUtil.i(TAG, String.format("Data from topic: {} " + dataFromTopic));
            orderService.updateStatus(dataFromTopic.getOrderId(),CANCELLED_PAYMENT_REJECTED);
            LoggerUtil.i(TAG, String.format("Process data from topic: {}", dataFromTopic));
        } catch (Exception e) {
            LoggerUtil.exception(TAG, e);
        }
    }
}
