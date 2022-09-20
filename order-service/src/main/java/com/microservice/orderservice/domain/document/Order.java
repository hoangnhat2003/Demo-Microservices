package com.microservice.orderservice.domain.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "tbl_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String status;
    private Long productId;
    private Integer quantity;
    private Integer amount;
    private Address billingAddress;
    private Address shippingAddress;
    private PaymentDetail paymentDetails;
    private Date createdDate;
    private Date updatedDate;
}
