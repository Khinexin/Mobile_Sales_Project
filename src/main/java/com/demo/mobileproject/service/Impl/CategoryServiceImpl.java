package com.demo.mobileproject.service.Impl;

import com.demo.mobileproject.domain.productcart.Category;
import com.demo.mobileproject.repository.CategoryRepository;
import com.demo.mobileproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findOneByIdSCategory(int id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateOneCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteOneCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
