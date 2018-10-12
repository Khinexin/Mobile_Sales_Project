package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Accessory_tbl;

import java.util.List;

public interface Accessory_tbl_Service {
    Accessory_tbl createAccessoryTbl(Accessory_tbl accessory_tbl);
    List<Accessory_tbl> findAllAccessoryTbls();
    Accessory_tbl findByIdAccessoryTbl(int id);
    void updateAccessoryTbl(int id);
    void deleteAccessoryTbl(int id);
}
