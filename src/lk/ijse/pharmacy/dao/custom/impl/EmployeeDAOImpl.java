package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.EmployeeDAO;

import java.sql.Connection;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
