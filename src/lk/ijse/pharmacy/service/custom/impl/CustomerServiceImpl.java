package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.CustomerDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.CustomerService;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;
    private Connection connection;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.customerDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.CUSTOMER);
        convertor = new Convertor();
    }

    @Override
    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDAO.add(convertor.fromECustomer(customer));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(convertor.fromECustomer(customer));
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<String> loadCustomerIDs() throws SQLException, ClassNotFoundException {
        return customerDAO.loadIDs();
    }
}
