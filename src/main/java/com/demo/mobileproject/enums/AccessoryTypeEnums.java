package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessoryTypeEnums {

    GEAR_VR("Gear VR"),
    CHARGER("Charger"),
    HEADPHONE("Headphone"),
    BATTERY_PACK("Battery pack"),
    BLUETOOTH_SPEAKER("Bluetooth speaker");

    private String accessoryType;


}
