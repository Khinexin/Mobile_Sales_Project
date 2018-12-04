package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.productcart.Category;
import com.demo.mobileproject.domain.productcart.MobileAccessory;
import com.demo.mobileproject.repository.MobileAccessoryRepository;
import com.demo.mobileproject.service.MobileAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileAccessoryServiceImpl implements MobileAccessoryService {

    @Autowired MobileAccessoryRepository mobileAccessoryRepository;

    @Override
    public MobileAccessory createMobileAccessory(MobileAccessory mobileAccessory) {
        return mobileAccessoryRepository.save(mobileAccessory);
    }

    @Override
    public MobileAccessory findOneByIdMobileAccessory(int id) {
        return mobileAccessoryRepository.getOne(id);
    }

    @Override
    public List<MobileAccessory> findAllMobileAccessory() {
        return mobileAccessoryRepository.findAll();
    }

    @Override
    public void updateOneMobileAccessory(MobileAccessory mobileAccessory) {
        mobileAccessoryRepository.saveAndFlush(mobileAccessory);
    }

    @Override
    public void deleteOneCMobileAccessory(int id) {
        mobileAccessoryRepository.deleteById(id);
    }

    @Override
    public List<MobileAccessory> findAllMobileAccessoryByCategoryId(int catId) {
        return mobileAccessoryRepository.findAllMobileAccessoryByCategoryId(catId);
    }

    @Override
    public List<MobileAccessory> findLatest4ListProducts() {
        return mobileAccessoryRepository.findProductByLatestInputed();
    }

    @Override
    public List<MobileAccessory> findTopSalesItem4Products() {
        return null;
    }
}
