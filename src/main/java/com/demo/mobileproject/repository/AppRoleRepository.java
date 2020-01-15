package com.demo.mobileproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.entity.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Integer>{
	
	@Query("select r from AppRole r where r.name= :name ")
	AppRole findRoleByName(@Param("name") String name);
}
