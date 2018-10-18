package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.RecordShopExpend;
import com.demo.mobileproject.repository.RecordShopExpend_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordShopExpend_ServiceImpl implements RecordShopExpend_Service {
    @Autowired
    private RecordShopExpend_Repository recordShopExpend_repository;

    @Override
    public RecordShopExpend createRecordShopExpend(RecordShopExpend recordShopExpend) {
        return recordShopExpend_repository.save(recordShopExpend);
    }

    @Override
    public List<RecordShopExpend> findAllRecordShopExpends() {
        return recordShopExpend_repository.findAll();
    }

    @Override
    public RecordShopExpend findByIdRecordShopExpend(int id) {
        return recordShopExpend_repository.findById(id).orElse(null);
    }

    @Override
    public void updateRecordShopExpended(int id) {
        recordShopExpend_repository.saveAndFlush(findByIdRecordShopExpend(id));
    }

    @Override
    public void deleteRecordShopExpended(int id) {
        recordShopExpend_repository.delete(findByIdRecordShopExpend(id));
    }
}
