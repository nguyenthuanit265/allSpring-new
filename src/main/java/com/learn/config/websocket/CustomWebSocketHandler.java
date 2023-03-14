package com.learn.config.websocket;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomWebSocketHandler implements WebSocketHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomWebSocketHandler.class);
    private final Gson gson = new Gson();
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    public CustomWebSocketHandler() {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("afterConnectionEstablished:: session {}", gson.toJson(String.valueOf(session)));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("handleMessage:: session {} :: message {}", gson.toJson(String.valueOf(session)), gson.toJson(String.valueOf(message)));
        LOGGER.info("message: {}", gson.toJson(String.valueOf(message.getPayload())));
        if (ObjectUtils.isEmpty(session)) {
            return;
        }
        sessions.add(session);

        LOGGER.info("sessions {}", gson.toJson(String.valueOf(sessions)));
        for (WebSocketSession s : sessions) {
            LOGGER.info("session: {}", session);
            s.sendMessage(message);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        LOGGER.info("afterConnectionClosed:: session {} :: closeStatus {}", gson.toJson(String.valueOf(session)), gson.toJson(String.valueOf(closeStatus)));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
