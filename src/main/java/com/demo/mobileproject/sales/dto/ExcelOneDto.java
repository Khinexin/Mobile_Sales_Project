package com.demo.mobileproject.sales.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcelOneDto {

	private Integer id;

	private String category;

	private String brand;

	private String itemName;
	private String otherName;
	
	private List<ExcelManyDto> excelManyDtoList;

}
