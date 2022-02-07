package com.panda.pauloartdraw.market.persistence;

import com.panda.pauloartdraw.market.domain.dto.InvoiceDto;
import com.panda.pauloartdraw.market.domain.repository.DomainInvoiceRepository;
import com.panda.pauloartdraw.market.persistence.crud.InvoiceCrudRepository;
import com.panda.pauloartdraw.market.persistence.entity.Invoice;
import com.panda.pauloartdraw.market.persistence.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository implements DomainInvoiceRepository {

    @Autowired
    private InvoiceCrudRepository invoiceCrudRepository;

    @Autowired
    private InvoiceMapper mapper;

    @Override
    public List<InvoiceDto> getAll() {
        return mapper.toInvoicesDto((List<Invoice>) invoiceCrudRepository.findAll());
    }

    @Override
    public Optional<List<InvoiceDto>> getAllByClient(String clientId) {
        return invoiceCrudRepository.findByClientId(clientId)
                .map(invoices -> mapper.toInvoicesDto(invoices));
    }

    @Override
    public InvoiceDto save(InvoiceDto invoice) {
        Invoice invoice1 = mapper.toInvoice(invoice);
        invoice1.getProducts().forEach(invoicesProduct -> invoicesProduct.setInvoice(invoice1));
        return mapper.toInvoiceDto(invoiceCrudRepository.save(invoice1));
    }
}
