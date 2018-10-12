package com.demo.mobileproject.repository;

import com.demo.mobileproject.domain.Authorized_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Authorized_table_Repository extends JpaRepository<Authorized_table,Integer> {
}
