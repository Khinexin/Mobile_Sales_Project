package com.demo.mobileproject.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shippingId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

//    @OneToOne(mappedBy = "deliveryAddress")
//    private Customer customer;

}
