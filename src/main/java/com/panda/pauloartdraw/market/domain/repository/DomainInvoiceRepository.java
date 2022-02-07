package com.panda.pauloartdraw.market.domain.repository;

import com.panda.pauloartdraw.market.domain.dto.InvoiceDto;

import java.util.List;
import java.util.Optional;

public interface DomainInvoiceRepository {
    List<InvoiceDto> getAll();
    Optional<List<InvoiceDto>> getAllByClient(String clientId);
    InvoiceDto save(InvoiceDto invoice);
}
