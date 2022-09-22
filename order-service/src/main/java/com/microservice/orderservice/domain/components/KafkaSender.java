package com.microservice.orderservice.domain.components;

import com.microservice.orderservice.config.kafka.KafkaTopicConfig;
import com.microservice.orderservice.domain.model.KafkaMessage;
import com.microservice.orderservice.domain.utils.GsonSingleton;
import com.microservice.orderservice.domain.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaSender {

    private static final String TAG = KafkaSender.class.getSimpleName();

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Async
    public void  sendMessage(KafkaMessage message) throws Exception {

        LoggerUtil.i(TAG, String.format("Sending message {} to topic: {} ,", GsonSingleton.getInstance().toJson(message.getMessage()),message.getTopicName()));
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(message.getTopicName() ,message.getMessage());
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LoggerUtil.i(TAG,String.format("Message {} delivered", message));

            }
            @Override
            public void onFailure(Throwable ex) {
                LoggerUtil.e(TAG,String.format("Unable to deliver message {}. {}", message,ex.getMessage()));
            }
        });
    }
}