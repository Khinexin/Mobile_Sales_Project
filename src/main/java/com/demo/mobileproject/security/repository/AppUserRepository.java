package com.demo.mobileproject.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.mobileproject.security.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	
	@Query("SELECT u FROM AppUser u WHERE u.email =:email")
	AppUser findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM AppUser u WHERE u.id <> 1 and u.id <> 2")
	List<AppUser> findExcept1And2Id();
}
