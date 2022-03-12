package com.panda.pauloartdraw.market.domain.repository;

import com.panda.pauloartdraw.market.domain.dto.CategoryDto;

import java.util.List;

public interface DomainCategoryRepository {

    List<CategoryDto> getAll();
}
