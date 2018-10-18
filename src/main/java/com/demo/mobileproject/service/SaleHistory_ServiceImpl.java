package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.SaleHistory;
import com.demo.mobileproject.repository.SaleHistory_Repository;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleHistory_ServiceImpl implements SaleHistory_Service{
    @Autowired
    private SaleHistory_Repository saleHistory_repository;

    @Override
    public SaleHistory createSaleHistory(SaleHistory saleHistory) {
        return saleHistory_repository.save(saleHistory);
    }

    @Override
    public List<SaleHistory> findAllSaleHistories() {
        return saleHistory_repository.findAll();
    }

    @Override
    public SaleHistory findByIdSaleHistory(int id) {
        return saleHistory_repository.findById(id).orElse(null);
    }

    @Override
    public void updateSaleHistory(int id) {
        saleHistory_repository.saveAndFlush(findByIdSaleHistory(id));
    }

    @Override
    public void deleteSaleHistory(int id) {
        saleHistory_repository.delete(findByIdSaleHistory(id));
    }
}
