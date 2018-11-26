package com.demo.mobileproject.domain.productcart;

import com.demo.mobileproject.domain.customer.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoppingCartId;

    private double price;

    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItems> cartItems;

}
