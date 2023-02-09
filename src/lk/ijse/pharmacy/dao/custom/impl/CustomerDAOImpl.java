package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.CustomerDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    private final Connection connection;

    public CustomerDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Customer customer) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?);",
                customer.getCId(),
                customer.getName(),
                customer.getAddress(),
                customer.getPhone());
    }

    @Override
    public ArrayList<lk.ijse.pharmacy.to.Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM customer");

        ArrayList<lk.ijse.pharmacy.to.Customer> arrayList=new ArrayList<>();

        while (resultSet.next()){
            arrayList.add(new lk.ijse.pharmacy.to.Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return arrayList;
    }

    @Override
    public lk.ijse.pharmacy.to.Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM customer WHERE cId = ?",id);
        while (resultSet.next()) {
            return new lk.ijse.pharmacy.to.Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("UPDATE customer SET name=?, address=?, phone=? WHERE cId = ?;",
                customer.getName(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getCId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("DELETE FROM customer WHERE cId = ?",id);
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT cId FROM customer");

        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
