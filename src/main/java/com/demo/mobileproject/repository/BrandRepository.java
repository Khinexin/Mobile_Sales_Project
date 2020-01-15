package com.demo.mobileproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	@Query("select b from Brand b where b.name =:name")
	Brand findBrandByName(@Param("name") String name);

}
