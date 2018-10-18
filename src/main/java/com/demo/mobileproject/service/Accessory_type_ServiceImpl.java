package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Accessory_type;
import com.demo.mobileproject.repository.Accessory_type_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Accessory_type_ServiceImpl implements Accessory_type_Service {
    @Autowired
    private Accessory_type_Repository accessory_type_repository;
    @Override
    public Accessory_type creAccessoryType(Accessory_type accessory_type) {
        return accessory_type_repository.save(accessory_type);
    }

    @Override
    public List<Accessory_type> findAllAccessoryTypes() {
        return accessory_type_repository.findAll();
    }

    @Override
    public Accessory_type findByIdAccessoryType(int id) {
        return accessory_type_repository.findById(id).orElse(null);
    }

    @Override
    public void updateAccessory_type(int id) {
        accessory_type_repository.saveAndFlush(findByIdAccessoryType(id));

    }

    @Override
    public void deleteAccessory_type(int id) {
        accessory_type_repository.delete(findByIdAccessoryType(id));

    }
}
