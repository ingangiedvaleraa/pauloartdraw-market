package com.panda.pauloartdraw.market.persistence.crud;

import com.panda.pauloartdraw.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    //@Query(value = "SELECT * FROM product WHERE category_id = ?", nativeQuery = true)

    List<Product> findByCategoryIdOrderByName(int categoryId);

    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);

}
