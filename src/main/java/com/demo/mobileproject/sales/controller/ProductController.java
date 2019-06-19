package com.demo.mobileproject.sales.controller;

import com.demo.mobileproject.sales.entity.Product;
import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.service.CategoryService;
import com.demo.mobileproject.sales.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class ProductController {

    final Log LOG= LogFactory.getLog(this.getClass());

    @Autowired ProductService productService;
    @Autowired CategoryService categoryService;

    //findAll
    @GetMapping("/proudctList")
    public String findAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "admin/list_product";
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model){
        model.addAttribute("categorys",categoryService.findAllCategory());
        Product product = new Product(); product.setId(-1);
        model.addAttribute("product", product);
        return "admin/create_product";
    }

    @PostMapping("/saveProduct")
    public String createProcessProduct(Model model, @ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){

            try {
                if (product.getId() == -1) {
                    productService.createProduct(product);
                } else {
                    productService.updateProduct(product);
                }
            } catch(ConstraintViolationException e){
                LOG.error("ConstraintViolationException : Error occur while saving Product:"+e.getMessage());
            }

        }else{
            LOG.error("binding result has error while saving product :: "+product.getId());
            return "admin/create_product";
        }
        return "redirect:/admin/proudctList";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(Model model,@PathVariable("id") int productId){
        try {
            model.addAttribute("product", productService.findByIdProduct(productId));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return "admin/create_product";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId")int productId){
        productService.deleteByIdProduct(productId);
        return "redirect:/admin/proudctList";
    }
}
