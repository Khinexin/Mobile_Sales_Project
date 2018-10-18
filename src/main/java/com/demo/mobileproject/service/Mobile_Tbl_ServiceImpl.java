package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Mobile_tbl;
import com.demo.mobileproject.repository.Mobile_tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mobile_Tbl_ServiceImpl implements Mobile_Tbl_Service{
    @Autowired
    private Mobile_tbl_Repository mobile_tbl_repository;

    @Override
    public Mobile_tbl createMobileTbl(Mobile_tbl mobile_tbl) {
        return mobile_tbl_repository.save(mobile_tbl);
    }

    @Override
    public List<Mobile_tbl> findAllMobileTbls() {
        return mobile_tbl_repository.findAll();
    }

    @Override
    public Mobile_tbl findByIdMobileTbl(int id) {
        return mobile_tbl_repository.findById(id).orElse(null);
    }

    @Override
    public void updateMobileTbl(int id) {
        mobile_tbl_repository.saveAndFlush(findByIdMobileTbl(id));
    }

    @Override
    public void deleteMobileTbl(int id) {
        mobile_tbl_repository.delete(findByIdMobileTbl(id));
    }
}
