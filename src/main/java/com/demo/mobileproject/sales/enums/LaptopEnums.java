package com.demo.mobileproject.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor @ToString
public enum LaptopEnums {

    ACER(1,"ACER"),
    ASUS(2,"ASUS"),
    DELL(3,"DELL"),
    HP(4,"HP"),
    LENOVO(5,"LENOVO"),
    MSI(6,"MSI"),
    PANASONIC(7,"PANASONIC"),
    SAMSUNG(8,"SAMSUNG"),
    SONY(9,"SONY"),
    TOSHIBA(10,"TOSHIBA");

    private  Integer id;
    private String name;

}
