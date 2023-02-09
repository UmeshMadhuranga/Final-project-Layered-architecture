package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee,String> {

    boolean add(Employee employee) throws ConstraintViolationException, SQLException, ClassNotFoundException;

    ArrayList<lk.ijse.pharmacy.to.Employee> getAll() throws SQLException, ClassNotFoundException;

    lk.ijse.pharmacy.to.Employee search(String uId) throws SQLException, ClassNotFoundException;

    boolean update(Employee employee) throws SQLException, ClassNotFoundException;

    boolean delete(String uId) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException;
}
