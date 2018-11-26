package com.demo.mobileproject.domain.productcart;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
public class MobileAccessory  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Category category;

    private String itemName;
    private String manufacturer;
    private String itemDescription;
    private double price;
    private int unitStock;

    @Transient
    private MultipartFile multipartFile;


}
