package com.demo.mobileproject.sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Brand {

    @Id
    @Column(name = "brand_name", unique = true)
    private String name;


}
