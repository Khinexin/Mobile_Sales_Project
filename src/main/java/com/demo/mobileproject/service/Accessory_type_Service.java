package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Accessory_tbl;
import com.demo.mobileproject.domain.Accessory_type;

import java.util.List;

public interface Accessory_type_Service {
    Accessory_type creAccessoryType(Accessory_type accessory_type);
    List<Accessory_type> findAllAccessoryTypes();
    Accessory_type findByIdAccessoryType(int id);
    void updateAccessory_type(int id);
    void deleteAccessory_type(int id);
}
