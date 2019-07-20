package com.demo.mobileproject.sales.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ProductSmartphoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;
    private String brand;

    private String phoneSeries;
    private String alsoKnownAs;

    private String networkTechnology;

    private String bodyDimensions;
    private String bodyWeight;
//    private String bodyBuild;
//    private String bodySIM;
//    private String bodyOther;
//
//    private String displayType;
//    private String displaySize;
//    private String displayResolution;
//    private String displayProtection;
//    private String displayOther;
//
//    private String launchAnnounced;
//    private String launchStatus;
//
//    private String platformOS;
//    private String platformChipset;
//    private String platformCPU;
//    private String platformGPU;
//
//    private String memoryCardSlot;
//    private String memoryInternal;
//
//    private String mainCameraSingle;
//    private String mainCameraDual;
//    private String mainCameraFeature;
//    private String mainCameraVideo;
//
//    private String selfieCameraSingle;
//    private String selfieCameraFeatures;
//    private String selfieCameraVideo;
//
//    private String soundLoudspeaker;
//    private String sound3_5mmJack;
//
//    private String commonsWLAN;
//    private String commonsBluetooth;
//    private String commonsGPS;
//    private String commonsNFC;
//    private String commonsRadio;
//    private String commonsUBS;
//
//    private String featuresSensors;
//
//    private String batteryType;
//    private String batteryCharging;
//    private String batteryTalkTimeMusicPlay;
//
//    private String miscColor;
    private String miscPrice;

    private String imageLocation;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<ProductInstock> productInstockList = new ArrayList<>();



}
