package com.microservice.customerservice.domain.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateCustomerRequest {
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String address;
}
