package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeService extends SuperService {

    boolean addEmployee(Employee employee) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    Employee searchEmployee(String id) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    ArrayList<Employee> getAllEmployee() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadEmployeeIDs() throws SQLException, ClassNotFoundException;
}
