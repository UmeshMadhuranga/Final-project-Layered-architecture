package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.to.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService extends SuperService {

    boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    Customer searchCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadCustomerIDs() throws SQLException, ClassNotFoundException;
}
