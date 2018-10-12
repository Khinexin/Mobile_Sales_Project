package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Accessory_tbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accessory_tbl_Repository extends JpaRepository<Accessory_tbl,Integer> {
}
