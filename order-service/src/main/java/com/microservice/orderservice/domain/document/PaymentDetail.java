package com.microservice.orderservice.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "tbl_payment_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardType;
    private String holderName;
    private Long customerId;
    private String cardNumber;
    private Integer cvv;
    private String expire;
    private Date createdDate;
    private Date updatedDate;
}
