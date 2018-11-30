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
public class CustomerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String payment_type;

    @OneToOne
    private CustomerPaymentVisa customerPaymentVisa;

}
