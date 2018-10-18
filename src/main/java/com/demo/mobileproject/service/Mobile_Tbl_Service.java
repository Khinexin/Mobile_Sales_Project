package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Mobile_tbl;

import java.util.List;

public interface Mobile_Tbl_Service {
    Mobile_tbl createMobileTbl(Mobile_tbl mobile_tbl);
    List<Mobile_tbl> findAllMobileTbls();
    Mobile_tbl findByIdMobileTbl(int id);
    void updateMobileTbl(int id);
    void deleteMobileTbl(int id);
}
