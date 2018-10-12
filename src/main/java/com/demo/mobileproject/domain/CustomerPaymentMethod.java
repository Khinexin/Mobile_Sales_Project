package com.demo.mobileproject.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class CustomerPaymentMethod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String payment_type;

    @OneToOne
    private CustomerPaymentVisa customerPaymentVisa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
