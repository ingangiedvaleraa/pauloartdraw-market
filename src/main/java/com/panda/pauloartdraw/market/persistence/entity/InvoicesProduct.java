package com.panda.pauloartdraw.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoices_products")
public class InvoicesProduct {

    @EmbeddedId
    private InvoicesProductPK id;

    private Integer quantity;

    private Double total;

    private Boolean state;

    @ManyToOne
    @MapsId("invoiceId")
    @JoinColumn(name = "invoice_id", insertable = false, updatable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public InvoicesProductPK getId() {
        return id;
    }

    public void setId(InvoicesProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
