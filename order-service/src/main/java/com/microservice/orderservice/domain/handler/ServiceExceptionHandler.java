package com.microservice.orderservice.domain.handler;

import com.microservice.orderservice.domain.exception.ServiceException;
import com.microservice.orderservice.domain.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ApiResponse handleServiceException(HttpServletRequest req, HttpServletResponse res,
                                              final ServiceException ex) throws IOException {
        ApiResponse apiError = new ApiResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return apiError;
    }
}
