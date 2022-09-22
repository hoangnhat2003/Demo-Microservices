package com.microservice.financeservice.domain.clients;

import com.microservice.financeservice.config.kafka.KafkaConfig;
import com.microservice.financeservice.domain.components.KafkaSender;
import com.microservice.financeservice.domain.model.KafkaMessage;
import com.microservice.financeservice.domain.model.PaymentConfirmationEvent;
import com.microservice.financeservice.domain.model.PaymentRejectionEvent;
import com.microservice.financeservice.domain.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceClient {

    private static final String TAG = OrderServiceClient.class.getSimpleName();

    @Autowired
    private KafkaSender kafkaSender;
    public void sendPaymentProcessingFailure(Long orderId) throws Exception {
        LoggerUtil.i(TAG, String.format("Rejecting payment for order {}", orderId));
        PaymentRejectionEvent event = new PaymentRejectionEvent(orderId);
        KafkaMessage message = new KafkaMessage(KafkaConfig.ORDER_PAYMENT_REJECT_TOPIC, event);
        kafkaSender.sendMessage(message);
    }

    public void sendPaymentProcessingSuccess(Long orderId) throws Exception {
        LoggerUtil.i(TAG, String.format("Confirming payment for order {}", orderId));
        PaymentConfirmationEvent event = new PaymentConfirmationEvent(orderId);
        KafkaMessage message = new KafkaMessage(KafkaConfig.ORDER_PAYMENT_CONFIRM_TOPIC, event);
        kafkaSender.sendMessage(message);
    }
}
