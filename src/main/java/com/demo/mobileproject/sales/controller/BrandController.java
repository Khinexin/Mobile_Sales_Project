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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.entity.Brand;
import com.demo.mobileproject.sales.enums.BrandEnum;
import com.demo.mobileproject.sales.service.BrandService;

@Controller
@RequestMapping("/admin")
public class BrandController {
	
	 private static final Logger LOG = LogManager.getLogger(BrandController.class);

	    @Autowired BrandService brandService;

	    // create
	    @GetMapping("/createBrand")
	    public String createBrand(ModelMap model) {
	        model.addAttribute("brand", Brand.builder().id(-1).build());
	        return "admin/create_brand";
	    }

	    @PostMapping("/saveBrand")
	    public String createProcessBrand(ModelMap model, @ModelAttribute("brand") @Valid Brand brand, BindingResult bindingResult) {
	        if(!bindingResult.hasErrors()){
	            try{
	                if (brand.getId() == -1) {
	                    brandService.createBrand(brand);
	                    LOG.info("New Brand has created");
	                } else{
	                    brandService.updateBrand(brand);
	                    LOG.info("Updated Brand where Id = "+brand.getId());
	                }
	            }catch (ConstraintViolationException e){
	                model.addAttribute("nameUniqueErr", "This name already exit!");
	                LOG.error("ConstraintViolationException : Error occur while saving Brand!"+"\n"+e.getMessage());
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	            return "redirect:/admin/brandlist";
	        } else{
	            return "admin/create_brand";
	        }

	    }

	    //update
	    @GetMapping("/editBrand/{catId}")
	    public String editBrandById(@PathVariable("catId") int id, ModelMap model) {
	        try {
	            model.addAttribute("brand", brandService.findByIdBrand(id));
	        } catch (ResourceNotFoundException e) {
	            e.printStackTrace();
	        }
	        return "admin/create_brand";
	    }

	    //findall
	    @GetMapping("/brandlist")
	    public String findAllBrandList(Model model) {
	        model.addAttribute("brandList", brandService.findAllBrand());
	        return "admin/list_brand";
	    }

	    //delete
	    @GetMapping("/deleteBrand/{catId}")
	    public String deleteBrandById(@PathVariable("catId") int id) {
	        brandService.deleteBrandById(id);
	        return "redirect:/admin/brandlist";
	    }

}
