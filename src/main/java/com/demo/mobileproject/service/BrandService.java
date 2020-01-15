package com.demo.mobileproject.service;

import java.util.List;

import com.demo.mobileproject.entity.Brand;
import com.demo.mobileproject.exception.ResourceNotFoundException;

public interface BrandService {

	Brand createBrand(Brand brand);

	Brand updateBrand(Brand brand);

	Brand findByBrandName(String name);

	Brand findByIdBrand(int id) throws ResourceNotFoundException;

	void deleteBrandById(int id);

	long countBrand();

	List<Brand> findAllBrand();

}
