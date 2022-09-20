package com.microservice.orderservice.domain.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException{
    private String code;
    private String message;
    private Object data;
}
