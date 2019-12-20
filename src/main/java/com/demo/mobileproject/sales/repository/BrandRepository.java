package com.demo.mobileproject.sales.repository;

import com.demo.mobileproject.sales.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
	
	@Query("select b from Brand b where b.name =:name")
	Brand findBrandByName(@Param("name")String name);

}
