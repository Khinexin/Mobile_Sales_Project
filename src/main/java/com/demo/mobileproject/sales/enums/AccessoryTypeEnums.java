package com.demo.mobileproject.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum AccessoryTypeEnums {

	GEAR_VR("Gear VR"), CHARGER("Charger"), HEADPHONE("Headphone"), BATTERY_PACK("Battery pack"),
	BLUETOOTH_SPEAKER("Bluetooth speaker");

	private String accessoryType;

}
