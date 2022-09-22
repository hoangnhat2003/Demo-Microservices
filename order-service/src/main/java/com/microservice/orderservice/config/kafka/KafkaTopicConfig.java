package com.microservice.orderservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic stockConfirmTopic() {
        return TopicBuilder
                .name(KafkaConfig.ORDER_STOCK_CONFIRM_TOPIC)
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic stockRejectTopic() {
        return TopicBuilder
                .name(KafkaConfig.ORDER_STOCK_REJECT_TOPIC)
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic paymentConfirmTopic() {
        return TopicBuilder
                .name(KafkaConfig.ORDER_PAYMENT_CONFIRM_TOPIC)
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic paymentRejectTopic() {
        return TopicBuilder
                .name(KafkaConfig.ORDER_PAYMENT_REJECT_TOPIC)
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic financePaymentProcessTopic() {
        return TopicBuilder
                .name(KafkaConfig.FINANCE_PAYMENT_PROCESS_TOPIC)
                .partitions(2)
                .build();
    }
}
