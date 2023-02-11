package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.PlaceOrderTMDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.SuperEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderTMDAOImpl implements PlaceOrderTMDAO {
    @Override
    public boolean add(SuperEntity T) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public SuperEntity search(Serializable serializable) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SuperEntity T) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Serializable serializable) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        return null;
    }
}
