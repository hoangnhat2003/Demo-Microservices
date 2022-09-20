package com.microservice.notificationservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Message<T> {
    private String msgId;

    private String from;
    private String to;
    private String name;
    private String type;
    private T data;
    private long time;

    public Message() {
        msgId = UUID.randomUUID().toString();
        time = System.currentTimeMillis();
    }

    public Message(String from, String to, String name, String type, T data) {
        this();
        this.from = from;
        this.to = to;
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
