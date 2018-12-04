package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.productcart.MobileAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileAccessoryRepository extends JpaRepository<MobileAccessory,Integer> {

    @Query("SELECT m FROM MobileAccessory m WHERE m.category.catId=:catId")
    List<MobileAccessory> findAllMobileAccessoryByCategoryId(@Param("catId") int catId);

    @Query("SELECT m FROM MobileAccessory m ORDER BY m.id DESC,4")
    List<MobileAccessory> findProductByLatestInputed();


//    @Query("")
//    List<MobileAccessory> findProductByTopSalesItem();
}
