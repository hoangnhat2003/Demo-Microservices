package com.microservice.financeservice.consumer;

import com.microservice.financeservice.config.kafka.KafkaConfig;
import com.microservice.financeservice.domain.document.Order;
import com.microservice.financeservice.domain.utils.LoggerUtil;
import com.microservice.financeservice.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {

    @Autowired
    private FinanceService financeService;
    private static final String TAG = PaymentEventListener.class.getSimpleName();


    @KafkaListener(topicPartitions = {@TopicPartition(topic = KafkaConfig.FINANCE_PAYMENT_PROCESS_TOPIC, partitions = "0")
    })
    public void processPayment(@Payload Order dataFromTopic) {
        try {
            LoggerUtil.i(TAG, String.format("Data from topic: {} " + dataFromTopic));
            financeService.createInvoice(dataFromTopic);
            LoggerUtil.i(TAG, String.format("Process data from topic: {}", dataFromTopic));
        } catch (Exception e) {
            LoggerUtil.exception(TAG, e);
        }
    }
}
