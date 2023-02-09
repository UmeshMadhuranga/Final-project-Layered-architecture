package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.Connection;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {

    private final Connection connection;

    public SupplierDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Supplier supplier) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO supplier VALUES (?,?,?,?,?);", supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }
}
