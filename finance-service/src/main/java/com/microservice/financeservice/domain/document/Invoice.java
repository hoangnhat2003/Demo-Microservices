package com.microservice.financeservice.domain.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "tbl_invoice")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long order_id;
    private Long customer_id;
    private Long product_id;
    private Long quantity;
    private Double product_price;
    private Long payment_detail_id;
    private Long billing_address_id;
    private Double total_charge_amount;
    private Date createdDate;
    private Date updatedDate;
}
