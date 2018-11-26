package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.productcart.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category findOneByIdSCategory(int id);
    List<Category> findAllCategory();
    void updateOneCategory(Category category);
    void deleteOneCategory(int id);
}
