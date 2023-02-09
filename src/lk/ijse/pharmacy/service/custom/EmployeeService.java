package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;

import java.sql.SQLException;

public interface EmployeeService extends SuperService {

    boolean addEmployee(Employee employee) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;
}
