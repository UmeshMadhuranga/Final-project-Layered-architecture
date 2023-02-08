package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.PaymentDAO;

import java.sql.Connection;

public class PaymentDAOImpl implements PaymentDAO {

    private final Connection connection;

    public PaymentDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
