package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Accessory_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accessory_type_Repository extends JpaRepository<Accessory_type,Integer> {
}
