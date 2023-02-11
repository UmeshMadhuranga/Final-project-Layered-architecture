package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.dto.SupplierDTO;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {

    private final Connection connection;

    public SupplierDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(lk.ijse.pharmacy.entity.Supplier supplier) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO supplier VALUES (?,?,?,?,?);", supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }

    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM supplier");

        ArrayList<Supplier> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new Supplier(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5))
            );
        }
        return list;
    }

    @Override
    public lk.ijse.pharmacy.entity.Supplier search(String sId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM supplier WHERE sId = ? ",sId);

        while (resultSet.next()){
            return new lk.ijse.pharmacy.entity.Supplier(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );

        }
        return null;
    }

    @Override
    public boolean update(lk.ijse.pharmacy.entity.Supplier supplier) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("UPDATE supplier SET name=?, email=?, address=?, phone=? WHERE sId = ?;",
                supplier.getName(),
                supplier.getEmail(),
                supplier.getAddress(),
                supplier.getPhone(),
                supplier.getSId()
        );
    }

    @Override
    public boolean delete(String sId) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("DELETE FROM supplier WHERE sId = ?",sId);
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        return null;
    }
}
