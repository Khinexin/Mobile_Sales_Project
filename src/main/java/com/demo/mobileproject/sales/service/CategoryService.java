package com.demo.mobileproject.sales.service;

import com.demo.mobileproject.sales.entity.Category;
import com.demo.mobileproject.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    void updateCategory(Category category);

    List<Category> findAllCategory();

    Category findByIdCategory(String name) throws ResourceNotFoundException;

    void deleteCategoryById(String name);

    long countCategoryTable();

}
