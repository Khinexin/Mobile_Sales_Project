package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum BrandEnum {

	APPLE("Apple"), SAMSUNG("Samsung");

	private String name;
}
