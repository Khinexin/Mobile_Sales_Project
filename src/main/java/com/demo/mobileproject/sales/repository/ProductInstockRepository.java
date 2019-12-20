package com.demo.mobileproject.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.sales.entity.ProductInstock;

@Repository
public interface ProductInstockRepository extends JpaRepository<ProductInstock, Integer>{
	
	@Modifying
	@Query(value = "delete from product_instock where product_id = :id",nativeQuery = true )
	void deleteProductInstockById(@Param("id") int id);
	
	@Query("SELECT pin FROM ProductInstock pin join pin.product pr where pr.id=:productId")
	List<ProductInstock> selectProductInsotckByProductId(@Param("productId") int id);
    

	
	
}


