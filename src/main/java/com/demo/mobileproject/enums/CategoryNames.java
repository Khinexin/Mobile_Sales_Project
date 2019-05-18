package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryNames {

    SMARTPHONE("Smartphone"),
    TABLET("Tablet"),
    LAPTOP("Laptop"),
    CAMERA("Camera"),
    ACCESSORY("Accessory"),
    SPARES("Smartphone Spares");

    private final String name;


}
