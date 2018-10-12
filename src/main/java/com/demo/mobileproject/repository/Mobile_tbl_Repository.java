package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Mobile_tbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mobile_tbl_Repository extends JpaRepository<Mobile_tbl,Integer> {
}
