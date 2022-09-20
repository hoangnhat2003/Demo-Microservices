package com.microservice.financeservice.domain.repository;

import com.microservice.financeservice.domain.document.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
