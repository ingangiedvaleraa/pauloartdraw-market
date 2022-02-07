package com.panda.pauloartdraw.market.persistence;

import com.panda.pauloartdraw.market.domain.dto.ProductDto;
import com.panda.pauloartdraw.market.domain.repository.DomainProductRepository;
import com.panda.pauloartdraw.market.persistence.crud.ProductCrudRepository;
import com.panda.pauloartdraw.market.persistence.entity.Product;
import com.panda.pauloartdraw.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements DomainProductRepository {

    @Autowired
    private ProductCrudRepository productRepo;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productRepo.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<Product> products = productRepo.findByCategoryIdOrderByName(categoryId);
        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<ProductDto>> getBelowStock(int quantity) {
        Optional<List<Product>> products = productRepo.findByStockLessThanAndState(quantity, true);
        return products.map(products1 -> mapper.toDomainProducts(products1));
    }

    @Override
    public Optional<ProductDto> getProduct(int id) {
        return productRepo.findById(id).map(product -> mapper.toDomainProduct(product));
    }

    @Override
    public ProductDto save(ProductDto product) {
        Product prod = mapper.toProduct(product);
        return mapper.toDomainProduct(productRepo.save(prod));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
