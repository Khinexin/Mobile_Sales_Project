package com.demo.mobileproject.sales.service.impl;

import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.entity.Brand;
import com.demo.mobileproject.sales.repository.BrandRepository;
import com.demo.mobileproject.sales.service.BrandService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand findByBrandName(String name) {
        return brandRepository.findBrandByName(name);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    @Override
    public void deleteBrandById(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public long countBrand() {
        return brandRepository.count();
    }

	@Override
	public List<Brand> findAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findByIdBrand(int id) throws ResourceNotFoundException{
		return brandRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
	}
    
    
}
