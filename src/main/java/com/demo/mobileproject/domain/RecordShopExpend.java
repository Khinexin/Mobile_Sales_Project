package com.demo.mobileproject.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class RecordShopExpend implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate expended_date;
    private String authorized_person_name;
    private String description;
    private double amount;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getExpended_date() {
        return expended_date;
    }

    public void setExpended_date(LocalDate expended_date) {
        this.expended_date = expended_date;
    }

    public String getAuthorized_person_name() {
        return authorized_person_name;
    }

    public void setAuthorized_person_name(String authorized_person_name) {
        this.authorized_person_name = authorized_person_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
