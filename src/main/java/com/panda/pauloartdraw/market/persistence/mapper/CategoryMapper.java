package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.CategoryDto;
import com.panda.pauloartdraw.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "name"),
            @Mapping(source = "state", target = "active"),
    })
    CategoryDto toDomainCategory(Category category);
    List<CategoryDto> toDomainCategories(List<Category> categories);

    @InheritInverseConfiguration
//    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto category);
}
