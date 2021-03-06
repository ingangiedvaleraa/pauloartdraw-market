package com.panda.pauloartdraw.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    private String id;

    private String firstname;

    private String lastname;

    private Long phone;

    private String address;

    private String email;

    private String password;

    @Column(name = "rol_id")
    private Integer rolId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Invoice> invoices;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol rol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
