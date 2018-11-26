package com.demo.mobileproject.domain.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shippingId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "shippingAddress")
    private Customer customer;

}
