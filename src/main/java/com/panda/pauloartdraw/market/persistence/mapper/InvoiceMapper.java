package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.InvoiceDto;
import com.panda.pauloartdraw.market.persistence.entity.Invoice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {InvoiceProductMapper.class})
public interface InvoiceMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "invoiceDate", target = "date"),
            @Mapping(source = "products", target = "products"),
            @Mapping(source = "comments", target = "comment"),
    })
    InvoiceDto toInvoiceDto(Invoice invoice);
    List<InvoiceDto> toInvoicesDto(List<Invoice> invoices);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Invoice toInvoice(InvoiceDto invoiceDto);
}
