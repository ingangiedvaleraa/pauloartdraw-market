package com.panda.pauloartdraw.market.domain.dto;

public class CategoryDto {
    private int id;
    private String name;
    private boolean active;
//    private DomainProduct products;

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
//
//    public DomainProduct getProducts() {
//        return products;
//    }
//
//    public void setProducts(DomainProduct products) {
//        this.products = products;
//    }
}
