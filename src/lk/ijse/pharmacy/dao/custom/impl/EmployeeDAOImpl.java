package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.EmployeeDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Employee employee) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO employee VALUES(?,?,?,?,?);", employee.getEmId(), employee.getName(),employee.getEmail(), employee.getAddress(), employee.getPhone());
    }

    @Override
    public ArrayList<lk.ijse.pharmacy.to.Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM employee");

        ArrayList<lk.ijse.pharmacy.to.Employee> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new lk.ijse.pharmacy.to.Employee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return list;
    }

    @Override
    public lk.ijse.pharmacy.to.Employee search(String emId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM employee WHERE emId = ? ",emId);

        while (resultSet.next()){
            return new lk.ijse.pharmacy.to.Employee(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5));

        }
        return null;
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("UPDATE employee SET name=?, email=?, address=?, phone=? WHERE emId = ?;",
                employee.getName(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPhone(),
                employee.getEmId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("DELETE FROM employee WHERE emId = ?",id);
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT emId FROM employee");

        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
