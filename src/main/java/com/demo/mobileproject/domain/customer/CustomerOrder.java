package com.demo.mobileproject.domain.customer;

import com.demo.mobileproject.domain.productcart.ShoppingCart;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @OneToOne
    private ShoppingCart cart;
    @OneToOne
    private Customer customer;
    @OneToOne
    private ShippingAddress shippingAddress;
    @OneToOne
    private BIllingAddress bIllingAddress;

}
