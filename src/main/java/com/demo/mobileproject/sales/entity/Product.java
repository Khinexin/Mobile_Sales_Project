package com.demo.mobileproject.sales.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER ) @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER ) @JoinColumn(name = "brand_id")
    private Brand brand;

    private String itemName;

    @OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductInstock> productInstockList = new ArrayList<>();
}
