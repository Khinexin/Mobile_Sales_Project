package com.demo.mobileproject.domain.customer;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CustomerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String payment_type;

    @OneToOne
    private CustomerPaymentVisa customerPaymentVisa;

}
