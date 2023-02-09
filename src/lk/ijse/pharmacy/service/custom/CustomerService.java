package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.to.Customer;

import java.sql.SQLException;

public interface CustomerService extends SuperService {
    boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
}
