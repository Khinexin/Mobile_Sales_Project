package com.demo.mobileproject.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Shopping_Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int customer_id;
    private String name;
    private double price;
    private int quantity;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate confirm_purchase_date;

    @ManyToOne
    private Accessory_tbl accessory_tbl;

    @ManyToOne
    private Mobile_tbl mobile_tbl;

    @ManyToOne
    private LoginCustomer_tbl loginCustomer_tbl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getConfirm_purchase_date() {
        return confirm_purchase_date;
    }

    public void setConfirm_purchase_date(LocalDate confirm_purchase_date) {
        this.confirm_purchase_date = confirm_purchase_date;
    }
}
