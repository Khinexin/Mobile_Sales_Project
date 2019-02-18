package com.demo.mobileproject.domain.customer;

import com.demo.mobileproject.domain.login.AppUser;
import com.demo.mobileproject.domain.productcart.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private Integer customerId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AppUser appUser;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DeliveryAddress deliveryAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BIllingAddress bIllingAddress;


}
