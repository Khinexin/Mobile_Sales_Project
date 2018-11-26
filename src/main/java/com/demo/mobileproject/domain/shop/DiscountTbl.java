package com.demo.mobileproject.domain.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class DiscountTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discountId;
    private Date discountStart;
    private Date discountEnd;
    private String discountDetails;
    private String discountCode;
    private int discountPercentage;


}
