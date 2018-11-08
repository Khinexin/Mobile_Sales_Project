package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Accessory_tbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Accessory_tbl_Repository extends JpaRepository<Accessory_tbl,Integer> {

    @Query("select a from Accessory_tbl a where a.total_instock_quantity <> 0")
    public List<Accessory_tbl> findAccessory_tblByTotal_instock_quantity();
}
