package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.ProductDto;
import com.panda.pauloartdraw.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category"),
//            @Mapping(source = "invoices", target = "invoices"),
    })
    ProductDto toDomainProduct(Product product);
    List<ProductDto> toDomainProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "code", ignore = true)
    Product toProduct(ProductDto product);
}
