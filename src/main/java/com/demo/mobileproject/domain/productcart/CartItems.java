package com.demo.mobileproject.domain.productcart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
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
