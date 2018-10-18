package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Authorized_table;
import com.demo.mobileproject.repository.Authorized_table_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Authorized_Table_Service_Impl implements Authorized_table_Service {
    @Autowired
    private Authorized_table_Repository authorized_table_repository;
    @Override
    public Authorized_table createAuthorizedTable(Authorized_table authorized_table) {
        return authorized_table_repository.save(authorized_table);
    }

    @Override
    public List<Authorized_table> findAllAuthorizedTables() {
        return authorized_table_repository.findAll();
    }

    @Override
    public Authorized_table findByIdAuthorizedTable(int id) {
        return authorized_table_repository.findById(id).orElse(null);
    }

    @Override
    public void updateAuthorized_Table(int id) {
        authorized_table_repository.saveAndFlush(findByIdAuthorizedTable(id));

    }

    @Override
    public void deleteAuthorized_Table(int id) {
        authorized_table_repository.delete(findByIdAuthorizedTable(id));
    }
}
