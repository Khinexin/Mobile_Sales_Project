package com.demo.mobileproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmartphoneSeriesEnum {

    /*APPLE*/
    Apple_iPad_Air("Apple iPad Air"),
    Apple_iPad_mini("Apple iPad mini"),
    Apple_iPad_Pro("Apple iPad Pro"),
    Apple_iPad("Apple iPad"),

    Apple_watch_series4("Apple Watch Series 4"),
    Apple_watch_series4_aluminum("Apple Watch Series 4 Aluminum"),
    Apple_watch_editionSeries3("Apple Watch Edition Series 3"),
    Apple_watch_series3("Apple Watch Series 3"),
    Apple_watch_series3_aluminum("Apple Watch Series 3 Aluminum"),
    Apple_watch_editionSeries1("Apple Watch Edition Series 2"),
    Apple_watch_series1("Apple Watch Series 2"),
    Apple_watch_series1_aluminum("Apple Watch Series 2 Aluminum"),

    Apple_iPhone_8Plus("Apple iPhone 8 Plus"),
    Apple_iPhone_8("Apple iPhone 8 "),
    Apple_iPhone7Plus("Apple iPhone 7 Plus"),
    Apple_iPhone7("Apple iPhone 7"),
    Apple_iPhone6s("Apple iPhone 6s"),
    Apple_iPhone_X("Apple iPhoneX"),
    Apple_iPhone_XS_Max("Apple iPhone XS Max"),
    Apple_iPhone_XS("Apple iPhone XS"),
    Apple_iPhone_XR("Apple iPhone XR"),

    /*SAMSUNG*/
    Samsung_view2("Samsung View 2"),
    Samsung_Galaxy_S10_5G("Samsung Galaxy S10 5G"),
    Samsung_Galaxy_S10Plus("Samsung Galaxy S10+");
    private String name;

}
