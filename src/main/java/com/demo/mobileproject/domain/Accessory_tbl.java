package com.demo.mobileproject.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Accessory_tbl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand_name;
    private String mobile_type;
    private double price_per_item;
    private String total_instock_quantity;
    private String inStock_Status;

    @ManyToOne
    private Accessory_type accessory_type;

    public Accessory_type getAccessory_type() {
        return accessory_type;
    }

    public void setAccessory_type(Accessory_type accessory_type) {
        this.accessory_type = accessory_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getMobile_type() {
        return mobile_type;
    }

    public void setMobile_type(String mobile_type) {
        this.mobile_type = mobile_type;
    }

    public double getPrice_per_item() {
        return price_per_item;
    }

    public void setPrice_per_item(double price_per_item) {
        this.price_per_item = price_per_item;
    }

    public String getTotal_instock_quantity() {
        return total_instock_quantity;
    }

    public void setTotal_instock_quantity(String total_instock_quantity) {
        this.total_instock_quantity = total_instock_quantity;
    }

    public String getInStock_Status() {
        return inStock_Status;
    }

    public void setInStock_Status(String inStock_Status) {
        this.inStock_Status = inStock_Status;
    }
}
