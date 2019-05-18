package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LaptopEnums {

    ACER("ACER"),
    ASUS("ASUS"),
    DELL("DELL"),
    HP("HP"),
    LENOVO("LENOVO"),
    MSI("MSI"),
    PANASONIC("PANASONIC"),
    SAMSUNG("SAMSUNG"),
    SONY("SONY"),
    TOSHIBA("TOSHIBA");


    private String name;

}
