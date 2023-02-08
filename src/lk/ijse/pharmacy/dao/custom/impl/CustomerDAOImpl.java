package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.CustomerDAO;

import java.sql.Connection;

public class CustomerDAOImpl implements CustomerDAO {

    private final Connection connection;

    public CustomerDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
