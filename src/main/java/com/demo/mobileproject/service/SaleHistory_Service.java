package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.SaleHistory;

import java.util.List;

public interface SaleHistory_Service {
    SaleHistory createSaleHistory(SaleHistory saleHistory);
    List<SaleHistory> findAllSaleHistories();
    SaleHistory findByIdSaleHistory(int id);
    void updateSaleHistory(int id);
    void deleteSaleHistory(int id);
}
