package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.EmployeeDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.EmployeeService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Employee;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {

    private Connection connection;
    private EmployeeDAO employeeDAO;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.employeeDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.EMPLOYEE);
        convertor = new Convertor();
    }

    @Override
    public boolean addEmployee(Employee employee) throws DuplicateException, InUseException, SQLException, ClassNotFoundException {
        return employeeDAO.add(convertor.fromEEmployee(employee));
    }
}
