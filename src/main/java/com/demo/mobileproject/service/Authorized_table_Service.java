package com.demo.mobileproject.service;

import com.demo.mobileproject.domain.Authorized_table;

import java.util.List;

public interface Authorized_table_Service {
    Authorized_table createAuthorizedTable(Authorized_table authorized_table);
    List<Authorized_table> findAllAuthorizedTables();
    Authorized_table findByIdAuthorizedTable(int id);
    void updateAuthorized_Table(int id);
    void deleteAuthorized_Table(int id);
}
