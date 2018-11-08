package com.demo.mobileproject.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Component
public class Shopping_Cart {

    //customer // address// payment // getter //setter

    private Integer cartId;

    private List<Accessory_tbl> accessory_tblList = new ArrayList<>();
    private List<Mobile_tbl> mobile_tblList = new ArrayList<>();

    private int accessoryquantity;
    private int mobilequantity;

    //add accessory to cart
    public boolean addAccessoryToCart(Accessory_tbl accessory_tbl) {
        return accessory_tblList.add(accessory_tbl);
    }

    public boolean addMobileToCart(Mobile_tbl mobileTbl) {
        return mobile_tblList.add(mobileTbl);
    }


    public void removeAll() {
        accessory_tblList.clear();
        mobile_tblList.clear();
    }

    //remove item Accessory
    public boolean removeAccessoryItem(Accessory_tbl accessory_tbl) {
        return accessory_tblList.remove(accessory_tbl);
    }

    public boolean removeMobileItem(Mobile_tbl mobileTbl) {
        return mobile_tblList.remove(mobileTbl);
    }

    public void updateAccessoryItemQuantity(int quantity, Accessory_tbl accessoryTbl) {
        accessoryTbl.setTotal_instock_quantity(quantity);
    }

    public void updateMobileItemQuantity(Mobile_tbl mobileTbl, int quantity) {
        mobileTbl.setQuantity(quantity);
    }

    public List<Accessory_tbl> getAccessory_tblList() {
        return accessory_tblList;
    }

    public void setAccessory_tblList(List<Accessory_tbl> accessory_tblList) {
        this.accessory_tblList = accessory_tblList;
    }

    public List<Mobile_tbl> getMobile_tblList() {
        return mobile_tblList;
    }

    public void setMobile_tblList(List<Mobile_tbl> mobile_tblList) {
        this.mobile_tblList = mobile_tblList;
    }

    public int getAccessoryquantity() {
        return accessoryquantity;
    }

    public void setAccessoryquantity(int accessoryquantity) {
        this.accessoryquantity = accessoryquantity;
    }

    public int getMobilequantity() {
        return mobilequantity;
    }

    public void setMobilequantity(int mobilequantity) {
        this.mobilequantity = mobilequantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    //    public double getSubtotal() {
//        return (mobile_tblList..getPrice() * mobilequantity) * (accessory_tbl.getPrice_per_item() * accessoryquantity);
//    }

}