package com.demo.mobileproject.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecordShopExpend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;
    private LocalDate expended_date;
    private String authorized_person_name;
    private String description;
    private double amount;
    private String remark;


}
