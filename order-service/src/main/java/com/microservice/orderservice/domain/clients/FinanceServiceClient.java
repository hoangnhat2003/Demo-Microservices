package com.microservice.orderservice.domain.clients;

import com.microservice.orderservice.config.kafka.KafkaConfig;
import com.microservice.orderservice.domain.components.KafkaSender;
import com.microservice.orderservice.domain.document.Order;
import com.microservice.orderservice.domain.model.KafkaMessage;
import com.microservice.orderservice.domain.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinanceServiceClient {

    @Autowired
    private KafkaSender kafkaSender;

    private static final String TAG = FinanceServiceClient.class.getSimpleName();

    public void sendPaymentProcessingEvent(Order order) {
        try {
            LoggerUtil.i(TAG, String.format("Processing payment for order {} by customer {}", order.getId(), order.getCustomerId()));
            KafkaMessage message = new KafkaMessage(KafkaConfig.FINANCE_PAYMENT_PROCESS_TOPIC, order);
            kafkaSender.sendMessage(message);
        }catch (Exception e) {
            LoggerUtil.e(TAG, String.format("Failed to process payment for order {} by customer {}", order.getId(), order.getCustomerId()));
            LoggerUtil.exception(TAG, e);
        }
    }
}
