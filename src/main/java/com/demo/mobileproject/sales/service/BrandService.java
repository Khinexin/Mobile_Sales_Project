package com.demo.mobileproject.sales.service;

import java.util.List;

import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.entity.Brand;

public interface BrandService {

    
    Brand createBrand(Brand brand);
    Brand updateBrand(Brand brand);
    
    Brand findByBrandName(String name);
    Brand findByIdBrand(int id) throws ResourceNotFoundException;
  
    void  deleteBrandById(int id);

    long countBrand();
    
    List<Brand> findAllBrand();

}
