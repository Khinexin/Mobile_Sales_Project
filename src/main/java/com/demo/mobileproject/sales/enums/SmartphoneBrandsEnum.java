package com.demo.mobileproject.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor @ToString
public enum SmartphoneBrandsEnum {

    APPLE(1,"APPLE"),
    SAMSUNG(2,"SAMSUNG"),
    NOKIA(3,"NOKIA"),
    SONY(4,"SONY"),
    LG(5,"LG"),
    HTC(6,"HTC"),
    LENOVO(7,"LENOVO"),
    XIAOMI(8,"XIAOMI"),
    GOOGLE(9,"GOOGLE"),
    OPPO(10,"OPPO"),
    ONEPLUS(11,"ONEPLUS"),
    VIVO(12,"VIVO"),
    MEIZU(13,"MEIZU"),
    ASUS(14,"ASUS"),
    ZTE(15,"ZTE"),
    MICROSOFT(16,"MICROSOFT");

    private Integer id;
    private String name;
}
