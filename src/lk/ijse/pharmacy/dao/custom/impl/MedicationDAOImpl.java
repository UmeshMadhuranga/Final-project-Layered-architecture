package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.MedicationDAO;

import java.sql.Connection;

public class MedicationDAOImpl implements MedicationDAO {

    private final Connection connection;

    public MedicationDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
