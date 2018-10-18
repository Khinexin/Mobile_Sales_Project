package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Accessory_tbl;
import com.demo.mobileproject.repository.Accessory_tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Accessory_Tbl_ServiceImpl implements Accessory_tbl_Service {
    @Autowired
    private Accessory_tbl_Repository accessory_tbl_repository;
    @Override
    public Accessory_tbl createAccessoryTbl(Accessory_tbl accessory_tbl) {
        return accessory_tbl_repository.save(accessory_tbl);
    }

    @Override
    public List<Accessory_tbl> findAllAccessoryTbls() {
        return accessory_tbl_repository.findAll();
    }

    @Override
    public Accessory_tbl findByIdAccessoryTbl(int id) {
        return accessory_tbl_repository.findById(id).orElse(null);
    }

    @Override
    public Accessory_tbl updateAccessoryTbl(Accessory_tbl accessory_tbl) {
        return accessory_tbl_repository.saveAndFlush(accessory_tbl);
    }

    @Override
    public void deleteAccessoryTbl(int id) {
        accessory_tbl_repository.delete(findByIdAccessoryTbl(id));
    }
}
