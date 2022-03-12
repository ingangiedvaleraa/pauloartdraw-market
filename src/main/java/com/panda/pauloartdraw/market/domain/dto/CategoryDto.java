package com.panda.pauloartdraw.market.domain.dto;
import com.panda.pauloartdraw.market.persistence.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    private int id;
    private String name;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
