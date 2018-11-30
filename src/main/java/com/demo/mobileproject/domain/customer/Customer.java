package com.demo.mobileproject.domain.customer;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    private String customerPhone;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ShippingAddress shippingAddress;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BIllingAddress bIllingAddress;
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private AppUser appUser;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;


}
