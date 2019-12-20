package com.demo.mobileproject.sales.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.sales.entity.Category;
import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	private static final Logger LOG = LogManager.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	// create
	@GetMapping("/createCategory")
	public String createCategory(ModelMap model) {
		model.addAttribute("category", Category.builder().id(-1).build());
		return "admin/create_category";
	}

	@PostMapping("/saveCategory")
	public String createProcessCategory(ModelMap model, @ModelAttribute("category") @Valid Category category,
			BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			try {
				if (category.getId() == -1) {
					categoryService.createCategory(category);
					LOG.info("New Category has created\t");
				} else {
					categoryService.updateCategory(category);
					LOG.info("Updated Category \t " + category.getId());
				}
			} catch (ConstraintViolationException e) {
				bindingResult.addError(new FieldError("category", "name", category.getName(), false, null, null,
						"* Same name already exit!"));
				LOG.error("ConstraintViolationException : Error occur while saving Category!" + "\n" + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/admin/categorylist";
		} else {
			return "admin/create_category";
		}

	}

	// update
	@GetMapping("/editCategory/{catId}")
	public String editCategoryById(@PathVariable("catId") int id, ModelMap model) {
		try {
			model.addAttribute("category", categoryService.findByIdCategory(id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return "admin/create_category";
	}

	// findall
	@GetMapping("/categorylist")
	public String findAllCategoryList(Model model) {
		model.addAttribute("categoryList", categoryService.findAllCategory());
		return "admin/list_category";
	}

	// delete
	@GetMapping("/deleteCategory/{catId}")
	public String deleteCategoryById(@PathVariable("catId") int id) {
		categoryService.deleteCategoryById(id);
		return "redirect:/admin/categorylist";
	}

}
