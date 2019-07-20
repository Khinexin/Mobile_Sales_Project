package com.demo.mobileproject.sales.service.impl;

import com.demo.mobileproject.sales.entity.Brand;
import com.demo.mobileproject.sales.repository.BrandRepository;
import com.demo.mobileproject.sales.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand findByBrandName(String name) {
        return brandRepository.getOne(name);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    @Override
    public void deleteBrandByName(String name) {
        brandRepository.deleteById(name);
    }

    @Override
    public long countBrand() {
        return brandRepository.count();
    }
}
