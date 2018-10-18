package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.RecordShopExpend;

import java.util.List;

public interface RecordShopExpend_Service {
    RecordShopExpend createRecordShopExpend(RecordShopExpend recordShopExpend);
    List<RecordShopExpend> findAllRecordShopExpends();
    RecordShopExpend findByIdRecordShopExpend(int id);
    void updateRecordShopExpended(int id);
    void deleteRecordShopExpended(int id);
}
