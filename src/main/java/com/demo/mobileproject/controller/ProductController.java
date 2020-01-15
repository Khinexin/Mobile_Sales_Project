package com.demo.mobileproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.dto.ExcelManyDto;
import com.demo.mobileproject.dto.ExcelOneDto;
import com.demo.mobileproject.entity.Product;
import com.demo.mobileproject.entity.ProductInstock;
import com.demo.mobileproject.service.BrandService;
import com.demo.mobileproject.service.CategoryService;
import com.demo.mobileproject.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	private static final Logger LOG = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	BrandService brandService;

	@GetMapping("/proudctList")
	public String findAllProducts(Model model) {
		model.addAttribute("products", productService.findAllProducts());
		return "admin/list_product";
	}

	@GetMapping("/createProduct")
	public String createProduct(Model model) {
		model.addAttribute("categorys", categoryService.findAllCategory());
		model.addAttribute("brands", brandService.findAllBrand());
		model.addAttribute("productDto", ExcelOneDto.builder().id(-1).build());
		return "admin/create_product";
	}

	@PostMapping("/saveProduct")
	public String createProcessProduct(Model model, @Valid @ModelAttribute("productDto") ExcelOneDto productDto,
			BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			LOG.info("Saving Product...");
			try {
				if (productDto.getId() == -1) {
					Product product = prepareProductBeforeCreate(productDto);
					productService.createProduct(product);
				} else {
					Product product = clearInstockBeforeUpdate(productDto);
					prepareProductBeforeUpdate(productDto, product);
					productService.updateProduct(product);
				}
			} catch (ConstraintViolationException e) {
				LOG.error("ConstraintViolationException : Error occur while saving Product:" + e.getMessage());

				return "admin/create_product";
			} catch (Exception e) {
				e.printStackTrace();
				return "admin/create_product";
			}

			return "redirect:/admin/proudctList";

		} else {
			model.addAttribute("categorys", categoryService.findAllCategory());
			model.addAttribute("brands", brandService.findAllBrand());
			LOG.error("binding result has error while saving product :: " + productDto.getId());
			return "admin/create_product";
		}

	}

	private Product prepareProductBeforeCreate(ExcelOneDto productDto) {
		Product product = new Product();
		List<ProductInstock> productInstockList = new ArrayList<ProductInstock>();

		for (ExcelManyDto inDto : productDto.getExcelManyDtoList()) {

			if (!((inDto.getColor().isEmpty() || null == inDto.getColor())
					&& (inDto.getMemory().isEmpty() || null == inDto.getMemory())
					&& (inDto.getSize().isEmpty() || null == inDto.getSize())
					&& (inDto.getPrice().isEmpty() || inDto.getPrice().equals("0.00") || inDto.getPrice().equals("0.0")
							|| inDto.getPrice().equals("0") || null == inDto.getPrice())
					&& (inDto.getQuantity().isEmpty() || inDto.getQuantity().equals("0")
							|| null == inDto.getQuantity()))) {

				System.out.println("in if .... many is not null");
				productInstockList.add(new ProductInstock(inDto, product));
			} else {
				System.out.println("in if .... many is null");
				productInstockList = null;
			}

		}

		product.setBrand(brandService.findByBrandName(productDto.getBrand()));
		product.setCategory(categoryService.findByCategoryName(productDto.getCategory()));
		product.setItemName(productDto.getItemName());
		product.setOtherName(productDto.getOtherName());
		product.setProductInstockList(productInstockList);
		return product;
	}

	private void prepareProductBeforeUpdate(ExcelOneDto productDto, Product product) {
		List<ProductInstock> productInstockList = new ArrayList<ProductInstock>();

		for (ExcelManyDto inDto : productDto.getExcelManyDtoList()) {
			productInstockList.add(new ProductInstock(inDto, product));
		}

		System.out.println("dto brand name " + productDto.getBrand());
		System.out.println("dto category name " + productDto.getCategory());

		product.setBrand(brandService.findByBrandName(productDto.getBrand()));
		product.setCategory(categoryService.findByCategoryName(productDto.getCategory()));
		product.setItemName(productDto.getItemName());
		product.setOtherName(productDto.getOtherName());
		product.setProductInstockList(productInstockList);
	}

	private Product clearInstockBeforeUpdate(ExcelOneDto productDto) {
		Product product = productService.findProduct(productDto.getId());
		
		if(productService.countProductInstockByProductId(product.getId())>0) {
			productService.deleteProductInstockByProductId(product.getId());
		}else {
			System.out.println("no productInstock ... initially.....");
		}
		
		return product;
	}

	@GetMapping("/editProduct/{id}")
	public String editProduct(Model model, @PathVariable("id") int productId) {
		Product product = productService.findProduct(productId);

		List<ExcelManyDto> manyDto = new ArrayList<ExcelManyDto>();

		for (ProductInstock pIn : product.getProductInstockList()) {
			ExcelManyDto pInDto = new ExcelManyDto();
			pInDto.setId(pIn.getId());
			pInDto.setMemory(pIn.getMemeory());
			pInDto.setColor(pIn.getColor());
			pInDto.setQuantity(String.valueOf(pIn.getQuantity()));
			pInDto.setSize(pIn.getSize());
			pInDto.setPrice(String.valueOf(pIn.getPrice()));
			manyDto.add(pInDto);
		}

		ExcelOneDto excelOneDto = new ExcelOneDto();
		excelOneDto.setId(product.getId());
		excelOneDto.setBrand(product.getBrand().getName());
		excelOneDto.setCategory(product.getCategory().getName());
		excelOneDto.setItemName(product.getItemName());
		excelOneDto.setOtherName(product.getOtherName());
		excelOneDto.setExcelManyDtoList(manyDto);

		model.addAttribute("productDto", excelOneDto);

		System.out.println(manyDto.size());

		model.addAttribute("listcount", manyDto.size() - 1);

		model.addAttribute("categorys", categoryService.findAllCategory());
		model.addAttribute("brands", brandService.findAllBrand());
		return "admin/create_product";
	}

	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/admin/proudctList";
	}

}
