package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.PaymentDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {

    private final Connection connection;

    public PaymentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Payment T) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Payment search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Payment T) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        return null;
    }
}
