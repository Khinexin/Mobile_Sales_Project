package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CategoryNamesEnum {

	SMARTPHONE(1, "Smartphone"), TABLET(2, "Tablet"), LAPTOP(3, "Laptop"), ACCESSORY(4, "Accessory"),
	SPARES(5, "Smartphone Spares"), IPAD(6, "iPad");

	private final Integer id;
	private final String name;

}
