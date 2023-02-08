package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.SupplierDAO;

import java.sql.Connection;

public class SupplierDAOImpl implements SupplierDAO {

    private final Connection connection;

    public SupplierDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
