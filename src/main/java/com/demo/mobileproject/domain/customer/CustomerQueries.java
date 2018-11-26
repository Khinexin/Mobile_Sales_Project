package com.demo.mobileproject.domain.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CustomerQueries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queryId;
    private String email;
    private String subject;
    private String password;


}
