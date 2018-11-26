package com.demo.mobileproject.domain.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CustomerPaymentVisa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int card_number;
    private int month;
    private int year;
    private int security_code;
    private String name_on_card;
    private String zip_code_or_postal_code;

}
