package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.CategoryDto;
import com.panda.pauloartdraw.market.domain.repository.DomainCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private DomainCategoryRepository categoryRepo;

    public List<CategoryDto> getAll() { return categoryRepo.getAll(); }
}
