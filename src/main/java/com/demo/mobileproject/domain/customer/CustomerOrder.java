package com.demo.mobileproject.domain.customer;

import com.demo.mobileproject.domain.productcart.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
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
