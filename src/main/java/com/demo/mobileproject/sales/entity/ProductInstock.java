package com.demo.mobileproject.sales.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.demo.mobileproject.sales.dto.ExcelManyDto;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInstock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String color;
	private String memeory;
	private double price;
	private String size;
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	public ProductInstock(ExcelManyDto excelManyDto, Product product) {
		super();
		this.color = excelManyDto.getColor();
		this.memeory = excelManyDto.getMemory();
		this.size = excelManyDto.getSize();
		this.product = product;
		
		if (null == excelManyDto.getPrice() || excelManyDto.getPrice().isEmpty() || excelManyDto.getPrice().trim().equals("")) {
			this.price = 0.00;
		} else {
			this.price = Double.parseDouble(excelManyDto.getPrice());
		}
		
		if (null == excelManyDto.getQuantity() || excelManyDto.getQuantity().isEmpty() || excelManyDto.getQuantity().trim().equals("")) {
			this.quantity = 0;
		} else {
			this.quantity = Integer.parseInt(excelManyDto.getQuantity());
		}
		
	}

}
