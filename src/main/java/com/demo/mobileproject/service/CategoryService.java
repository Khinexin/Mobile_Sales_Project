package com.demo.mobileproject.service;

import com.demo.mobileproject.entity.Category;
import com.demo.mobileproject.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    void updateCategory(Category category);

    List<Category> findAllCategory();

    Category findByIdCategory(int id) throws ResourceNotFoundException;

    void deleteByIdCategory(int id);

    long countCategoryTable();

}
