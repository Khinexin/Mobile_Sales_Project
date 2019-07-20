package com.demo.mobileproject.sales.service.impl;

import java.util.List;

import com.demo.mobileproject.sales.entity.ProductSmartphoneDetails;
import com.demo.mobileproject.sales.service.ProductSmartphoneDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mobileproject.exception.ResourceNotFoundException;
import com.demo.mobileproject.sales.repository.ProductSmartphoneDetailsRepository;

@Service
public class ProductSmartphoneDetailsServiceImpl implements ProductSmartphoneDetailsService {

    @Autowired
    ProductSmartphoneDetailsRepository productSmartphoneDetailsRepository;

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    @Override
    public ProductSmartphoneDetails createProduct(ProductSmartphoneDetails product) {
        return productSmartphoneDetailsRepository.save(product);
    }

    @Override
    public void updateProduct(ProductSmartphoneDetails product) {
        productSmartphoneDetailsRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductSmartphoneDetails> findAllProduct() {
        return productSmartphoneDetailsRepository.findAll();
    }

    @Override
    public ProductSmartphoneDetails findByIdProduct(int id) throws ResourceNotFoundException {
        return productSmartphoneDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public void deleteByIdProduct(int id) {
        productSmartphoneDetailsRepository.deleteById(id);
    }

    @Override
    public long countProduct() {
        return productSmartphoneDetailsRepository.count();
    }
/*
    @Override
    public void saveImage(MultipartFile imageFile1, MultipartFile imageFile2, MultipartFile imageFile3) throws Exception{

        String folder = "..//photos/";

        byte[] bytes1 = imageFile1.getBytes();
        byte[] bytes2 = imageFile2.getBytes();
        byte[] bytes3 = imageFile3.getBytes();

        Path path1 = Paths.get(folder + imageFile1.getOriginalFilename());
        Path path2 = Paths.get(folder + imageFile2.getOriginalFilename());
        Path path3 = Paths.get(folder + imageFile3.getOriginalFilename());

        Files.write(path1, bytes1);
        Files.write(path1, bytes2);
        Files.write(path1, bytes3);
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }*/

}
