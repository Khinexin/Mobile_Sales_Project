package com.demo.mobileproject.sales.service;

import java.util.List;

import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.entity.ProductSmartphoneDetails;

public interface ProductSmartphoneDetailsService {

    ProductSmartphoneDetails createProduct(ProductSmartphoneDetails product) ;

    void updateProduct(ProductSmartphoneDetails product);

    List<ProductSmartphoneDetails> findAllProduct();

    ProductSmartphoneDetails findByIdProduct(int id) throws ResourceNotFoundException;

    void deleteByIdProduct(int id);

    long countProduct();


}
