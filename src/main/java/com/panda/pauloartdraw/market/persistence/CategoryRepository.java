package com.panda.pauloartdraw.market.persistence;

import com.panda.pauloartdraw.market.domain.dto.CategoryDto;
import com.panda.pauloartdraw.market.domain.repository.DomainCategoryRepository;
import com.panda.pauloartdraw.market.persistence.crud.CategoryCrudRepository;
import com.panda.pauloartdraw.market.persistence.entity.Category;
import com.panda.pauloartdraw.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements DomainCategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryRepo;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = (List<Category>) categoryRepo.findAll();
        return mapper.toDomainCategories(categories);
    }
}
