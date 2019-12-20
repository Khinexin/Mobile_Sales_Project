package com.demo.mobileproject.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcelManyDto {
	
	private Integer id;

	private String color;
	private String memory;
	private double price;
	private String size;
	private int quantity;

}
