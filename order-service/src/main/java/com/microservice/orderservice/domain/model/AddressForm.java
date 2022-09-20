package com.microservice.orderservice.domain.model;

import lombok.Data;

@Data
public class AddressForm {
    private String line;
    private String city;
    private String country;
    private String postcode;
}
