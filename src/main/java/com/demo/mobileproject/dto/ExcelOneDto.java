package com.demo.mobileproject.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

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

	@NotEmpty
	private String category;

	@NotEmpty
	private String brand;

	@NotEmpty
	private String itemName;
	private String otherName;

	private List<ExcelManyDto> excelManyDtoList;

}
