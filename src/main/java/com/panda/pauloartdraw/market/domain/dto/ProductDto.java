package com.panda.pauloartdraw.market.domain.dto;

public class ProductDto {

    private int id;

    private String name;

    private String image;

    private int categoryId;

    private double price;

    private int stock;

    private boolean active;

    private CategoryDto category;

//    private List<DomainInvoice> invoices;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //    public List<DomainInvoice> getInvoices() {
//        return invoices;
//    }
//
//    public void setInvoices(List<DomainInvoice> invoices) {
//        this.invoices = invoices;
//    }
}
