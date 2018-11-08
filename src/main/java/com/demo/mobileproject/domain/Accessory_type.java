package com.demo.mobileproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Accessory_type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type_name;

    @OneToMany(mappedBy = "accessory_type", orphanRemoval = true)
    private List<Accessory_tbl> accessory_tbl = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public List<Accessory_tbl> getAccessory_tbl() {
        return accessory_tbl;
    }

    public void setAccessory_tbl(List<Accessory_tbl> accessory_tbl) {
        this.accessory_tbl = accessory_tbl;
    }
}
