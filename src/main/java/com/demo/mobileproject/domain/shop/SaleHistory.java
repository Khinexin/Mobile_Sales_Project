package com.demo.mobileproject.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SaleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;
    private String payment_method;
    private String item_name;
    private double price_per_item;
    private int quantity;
    private double discount;
    private double total_price;
    private String bought_customer;
    private LocalDate sold_date;

}
