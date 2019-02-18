package com.demo.mobileproject.domain.productcart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
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

//    @DateTimeFormat(pattern = "yyyy/mm/dd")
//    private Date dateArrival;

    @Transient
    private MultipartFile multipartFile;


}
