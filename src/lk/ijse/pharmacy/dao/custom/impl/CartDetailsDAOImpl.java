package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.CartDetailsDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class CartDetailsDAOImpl implements CartDetailsDAO {
    @Override
    public boolean add(OrderDetails T) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetails T) throws SQLException, ClassNotFoundException {
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
