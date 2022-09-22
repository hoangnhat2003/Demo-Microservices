package com.microservice.financeservice.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "tbl_invoice")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long customerId;
    private Long productId;
    private Long quantity;
    private Double productPrice;
    private Long paymentDetailId;
    private Long billingAddressId;
    private Double totalChargeAmount;
    private Date createdDate;
    private Date updatedDate;
}
