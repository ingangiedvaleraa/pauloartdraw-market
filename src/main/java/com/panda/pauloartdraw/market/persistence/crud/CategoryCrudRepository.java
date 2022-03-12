package com.panda.pauloartdraw.market.persistence.crud;

import com.panda.pauloartdraw.market.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryCrudRepository extends JpaRepository<Category, Integer> {

}
