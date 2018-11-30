package com.demo.mobileproject.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BIllingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billinId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "bIllingAddress")
    private Customer customer;


}
