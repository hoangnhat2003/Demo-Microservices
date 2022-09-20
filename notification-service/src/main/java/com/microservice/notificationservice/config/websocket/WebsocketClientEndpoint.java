package com.microservice.notificationservice.config.websocket;

import com.microservice.notificationservice.domain.model.Message;
import com.microservice.notificationservice.domain.utils.GsonSingleton;
import com.microservice.notificationservice.domain.utils.LoggerUtil;
import org.springframework.stereotype.Component;

import javax.websocket.*;


@ClientEndpoint
@Component
public class WebsocketClientEndpoint  {

    private static final String TAG = WebsocketClientEndpoint.class.getSimpleName();

    /**
     * Callback hook for Connection open events.
     *
     * @param session the session which is opened.
     */
    @OnOpen
    public void onOpen(Session session) {
        LoggerUtil.i(TAG, String.format("Connection established. session id: %s", session.getId()));
    }


    /**
     * Callback hook for Message Events. This method will be invoked when a client send a message.
     *
     * @param message The text message
     */
    @OnMessage
    public void onMessage(Message message) {
        LoggerUtil.i(TAG, String.format("[%s:%s] %s", message.getName(), message.getType(), GsonSingleton.getInstance().toJson( message.getData())));
    }

    /**
     * Callback hook for Connection close events.
     *
     * @param session the userSession which is getting closed.
     * @param reason the reason for connection close
     */
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        LoggerUtil.i(TAG, String.format("Closing session => %s - %s", session.getId(), reason.getReasonPhrase()));
    }

}
