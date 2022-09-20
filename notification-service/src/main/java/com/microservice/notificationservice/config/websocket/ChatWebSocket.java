package com.microservice.notificationservice.config.websocket;
import com.microservice.notificationservice.domain.model.Message;
import com.microservice.notificationservice.domain.utils.LoggerUtil;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
@Component
@ServerEndpoint(value = "/chat/{customerId}")
public class ChatWebSocket {

    private static final String TAG = ChatWebSocket.class.getSimpleName();

    @OnOpen
    public void open(Session session, @PathParam("customerId") String customerId) {
        LoggerUtil.i(TAG, String.format("On open, session_id = %s", session.getId()));
        LoggerUtil.i(TAG, String.format("Successful connection, customerId = %s", customerId));
    }

    @OnMessage
    public void handleMessage(Message message, Session session) {
        LoggerUtil.i(TAG, String.format("On message, session_id = %s", session.getId()));
        LoggerUtil.i(TAG, String.format("message received from client, %s", message));
    }

    @OnClose
    public void close(Session session) {
        LoggerUtil.i(TAG, String.format("On close, session_id = %s", session.getId()));
        LoggerUtil.i(TAG, "Connection close");
    }

    @OnError
    public void onError(Throwable e, Session session) {
        LoggerUtil.i(TAG, String.format("On error, session_id = %s", session.getId()));
        LoggerUtil.exception(TAG, (Exception) e);
    }
}
