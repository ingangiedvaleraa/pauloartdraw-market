package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.CategoryDto;
import com.panda.pauloartdraw.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "description", target = "name"),
            @Mapping(source = "state", target = "active"),
//            @Mapping(source = "products", target = "products")
    })
    CategoryDto toDomainCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto category);
}
