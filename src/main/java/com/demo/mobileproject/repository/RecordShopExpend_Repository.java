package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.RecordShopExpend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordShopExpend_Repository extends JpaRepository<RecordShopExpend,Integer> {
}
