package com.demo.mobileproject.sales.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ProductInstock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;
    private String memeory;
    private String price;
    private String size;
    private int quantity;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
}
