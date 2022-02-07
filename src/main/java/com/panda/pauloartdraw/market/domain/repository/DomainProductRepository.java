package com.panda.pauloartdraw.market.domain.repository;

import com.panda.pauloartdraw.market.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface DomainProductRepository {

    List<ProductDto> getAll();

    Optional<List<ProductDto>> getByCategory(int categoryId);

    Optional<List<ProductDto>> getBelowStock(int quantity);

    Optional<ProductDto> getProduct(int id);

    ProductDto save(ProductDto product);

    void delete(int id);
}
