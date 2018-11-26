package com.demo.mobileproject.domain.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BIllingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String billinId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "bIllingAddress")
    private Customer customer;


}
