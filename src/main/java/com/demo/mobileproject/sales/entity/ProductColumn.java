package com.demo.mobileproject.sales.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Data @NoArgsConstructor
public class ProductColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;
    private String memeory;
    private String price;
    private String size;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
