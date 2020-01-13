package com.demo.mobileproject.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.mobileproject.sales.service.BrandService;
import com.demo.mobileproject.sales.service.CategoryService;
import com.demo.mobileproject.sales.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserViewController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	BrandService brandService;
	
	
	
	@GetMapping("/product/category")
	public String getProductByCategory(Model model, @RequestParam("category")String category) {
		
		model.addAttribute("prods",productService.findProductsByCategory(category));
		
		return "products";
	}
	
	@GetMapping("/product/brand")
	public String getProductByBrand(Model model, @RequestParam("brand")String brand) {
		
		model.addAttribute("prods",productService.findProductsByBrand(brand));
		
		return "products";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@GetMapping(value = { "?lang=us", "?lang=mm" })
	public String makeUSUrl(HttpServletRequest request) {
		return request.getServletPath() + "/" + request.getRequestURL();
	}
	
	
}