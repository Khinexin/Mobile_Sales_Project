package com.demo.mobileproject.sales.dto;

import java.util.ArrayList;

import lombok.*;

@Data
@NoArgsConstructor
public class ShoppingCartDTO {

	private Integer id;

	private ArrayList<Integer> productIds;
	private String productName;

	private ArrayList<Integer> product_SubIds;
	private String pricePerItem;
	private int quantity;

}
