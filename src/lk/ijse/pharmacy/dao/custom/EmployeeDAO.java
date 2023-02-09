package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.OrderDetails;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee,String> {

    boolean add(Employee employee) throws ConstraintViolationException, SQLException, ClassNotFoundException;
}
