package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmartphoneBrandsEnum {

    APPLE("APPLE"),
    SAMSUNG("SAMSUNG"),
    HUAWEI("HUAWEI"),
    NOKIA("NOKIA"),
    SONY("SONY"),
    LG("LG"),
    HTC("HTC"),
    LENOVO("LENOVO"),
    XIAOMI("XIAOMI"),
    GOOGLE("GOOGLE"),
    OPPO("OPPO"),
    ONEPLUS("ONEPLUS"),
    VIVO("VIVO"),
    MEIZU("MEIZU"),
    ASUS("ASUS"),
    ZTE("ZTE"),
    MICROSOFT("MICROSOFT");

    private String name;
}
