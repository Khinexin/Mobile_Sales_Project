package com.demo.mobileproject.service;



import com.demo.mobileproject.domain.productcart.MobileAccessory;

import java.util.List;

public interface MobileAccessoryService {
    MobileAccessory createMobileAccessory(MobileAccessory mobileAccessory);
    MobileAccessory findOneByIdMobileAccessory(int id);
    List<MobileAccessory> findAllMobileAccessory();
    List<MobileAccessory> findAllMobileAccessoryByCategoryId(int catId);

    List<MobileAccessory> findLatest4ListProducts();
    List<MobileAccessory> findTopSalesItem4Products();

    void updateOneMobileAccessory(MobileAccessory mobileAccessory);
    void deleteOneCMobileAccessory(int id);

}
