package com.microservice.notificationservice.domain.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Component
public class SendMessageAsync {

    @Autowired
    private WebSocketConnect webSocketConnect;

    public void send(Long customerId, String message) throws Exception {
        // Connect to websocket server
        Session session = webSocketConnect.connect(customerId);

        // Send message
        webSocketConnect.sendMessageAsync(message, session);
    }
}
