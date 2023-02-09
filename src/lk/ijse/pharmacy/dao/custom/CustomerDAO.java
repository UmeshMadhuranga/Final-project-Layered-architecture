package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.service.exception.DuplicateException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    boolean add(Customer customer) throws ConstraintViolationException, SQLException, ClassNotFoundException;

    ArrayList<lk.ijse.pharmacy.to.Customer> getAll() throws SQLException, ClassNotFoundException;

    lk.ijse.pharmacy.to.Customer search(String uId) throws SQLException, ClassNotFoundException;

    boolean update(Customer customer) throws SQLException, ClassNotFoundException;

    boolean delete(String uId) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException;
}
