package com.example.parcial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sales_id;

    @Column(nullable = false, length = 50)
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_sales_to_customers"))
    @JsonIgnore
    private Customers customers;

    @ManyToMany
    @JoinTable(name = "sales_products",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private Set<Products> products = new HashSet<>();


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void addProduct(Products product) {
        this.products.add(product);
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
