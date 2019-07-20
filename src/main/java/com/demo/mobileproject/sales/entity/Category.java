package com.demo.mobileproject.sales.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Category {

    @Id
    @NotEmpty(message = "Category name cannot be empty")
    @Column(name = "name", unique = true)
    private String name;

}
