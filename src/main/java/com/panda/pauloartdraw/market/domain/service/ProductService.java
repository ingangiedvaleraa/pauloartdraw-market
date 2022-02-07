package com.panda.pauloartdraw.market.domain.service;

import com.panda.pauloartdraw.market.domain.dto.ProductDto;
import com.panda.pauloartdraw.market.domain.repository.DomainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private DomainProductRepository productRepo;

    public List<ProductDto> getAll() {
        return productRepo.getAll();
    }

    public Optional<ProductDto> getProduct(int id) {
        return productRepo.getProduct(id);
    }

    public Optional<List<ProductDto>> getByCategory (int id) {
        return productRepo.getByCategory(id);
    }

    public ProductDto save(ProductDto product) {
        return productRepo.save(product);
    }

    public boolean delete (int id) {
//        if (getProduct(id).isPresent()) {
//            productRepo.delete(id);
//            return true;
//        } else {
//            return false;
//        }
        return getProduct(id).map(product -> {
            productRepo.delete(id);
            return true;
        }).orElse(false);
    }

}
