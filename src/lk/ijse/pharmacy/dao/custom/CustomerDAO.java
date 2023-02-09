package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.service.exception.DuplicateException;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    boolean add(Customer customer) throws ConstraintViolationException, SQLException, ClassNotFoundException;
}
