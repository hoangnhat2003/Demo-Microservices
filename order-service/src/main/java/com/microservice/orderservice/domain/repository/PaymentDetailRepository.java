package com.microservice.orderservice.domain.repository;

import com.microservice.orderservice.domain.document.PaymentDetail;
import org.springframework.data.repository.CrudRepository;

public interface PaymentDetailRepository extends CrudRepository<PaymentDetail, Long> {
}
