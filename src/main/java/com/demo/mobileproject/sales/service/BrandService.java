package com.demo.mobileproject.sales.service;

import com.demo.mobileproject.sales.entity.Brand;

public interface BrandService {

    Brand findByBrandName(String name);
    Brand saveBrand(Brand brand);
    Brand updateBrand(Brand brand);
    void  deleteBrandByName(String name);

    long countBrand();

}
