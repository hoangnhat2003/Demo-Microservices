package com.microservice.authserver.domain.exception;

import javax.security.sasl.AuthenticationException;

public class AuthExceptionHandling extends AuthenticationException {
    public AuthExceptionHandling(String message) {
        super(message);
    }
}
