package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.EmployeeDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Employee employee) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO employee VALUES(?,?,?,?,?);", employee.getEmId(), employee.getName(),employee.getEmail(), employee.getAddress(), employee.getPhone());
    }
}
