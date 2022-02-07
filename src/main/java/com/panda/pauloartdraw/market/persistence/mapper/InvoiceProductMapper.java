package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.InvoiceProductDto;
import com.panda.pauloartdraw.market.persistence.entity.InvoicesProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface InvoiceProductMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    InvoiceProductDto toInvoiceProductDto(InvoicesProduct invoicesProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "invoice", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.invoiceId", ignore = true)
    })
    InvoicesProduct toInvoiceProduct(InvoiceProductDto invoiceProductDto);
}
