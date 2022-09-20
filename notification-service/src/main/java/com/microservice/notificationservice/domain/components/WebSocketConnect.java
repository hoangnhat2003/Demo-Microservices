package com.microservice.notificationservice.domain.components;

import com.microservice.notificationservice.config.websocket.WebsocketClientEndpoint;
import com.microservice.notificationservice.domain.utils.LoggerUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class WebSocketConnect {

    private static final String TAG = WebSocketConnect.class.getSimpleName();


    /**
     * Connect to Websocket Server
     *
     * @param customerId
     * @throws Exception
     */
    public Session connect(Long customerId) throws Exception {
        URI uri = null;
        try {
            uri = new URI(String.format("ws://localhost:6652/%s", customerId));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(WebsocketClientEndpoint.class, uri);
        if (session == null) {
            LoggerUtil.e(TAG, "Failed to connect to web socket server. Session null");
        }

        return session;
    }

    /**
     * Send message async
     *
     * @param message
     * @param session
     * @throws Exception
     */
    @Async
    public void sendMessageAsync(String message, Session session) throws Exception {
        LoggerUtil.i(TAG, String.format("Start send message with session id = %s", session.getId()));
        session.getBasicRemote().sendText(message);
        LoggerUtil.i(TAG, String.format("Finished send message with session id = %s", session.getId()));
    }
}
