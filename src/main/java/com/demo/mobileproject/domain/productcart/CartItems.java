package com.demo.mobileproject.domain.productcart;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartItems  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    private int quantity;
    private double price;

    @ManyToOne
    private MobileAccessory mobileAccessory;
    @ManyToOne
    private ShoppingCart shoppingCart;


}
