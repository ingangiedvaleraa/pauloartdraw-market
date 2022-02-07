package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.InvoiceDto;
import com.panda.pauloartdraw.market.domain.repository.DomainInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private DomainInvoiceRepository invoiceRepo;

    public List<InvoiceDto> getAll() {
        return invoiceRepo.getAll();
    }

    public Optional<List<InvoiceDto>> getAllByClient(String clientId) {
        return invoiceRepo.getAllByClient(clientId);
    }

    public InvoiceDto save(InvoiceDto purchase) {
        return invoiceRepo.save(purchase);
    }
}
