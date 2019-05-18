package com.demo.mobileproject.entity.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCartDTO {

    private Integer id;

    private ArrayList<Integer> productIds;
    private String productName;

    private ArrayList<Integer> product_SubIds;
    private String pricePerItem;
    private int quantity;

}
