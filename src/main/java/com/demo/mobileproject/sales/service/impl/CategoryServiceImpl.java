package com.demo.mobileproject.sales.service.impl;

import java.util.List;

import com.demo.mobileproject.sales.entity.Category;
import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.repository.CategoryRepository;
import com.demo.mobileproject.sales.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByIdCategory(int id) throws ResourceNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public long countCategoryTable() {
        return categoryRepository.count();
    }

	@Override
	public Category findByCategoryName(String name) {
		return categoryRepository.findCategoryByName(name);
	}

    

}
