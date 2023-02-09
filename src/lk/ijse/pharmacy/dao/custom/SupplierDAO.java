package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier,String> {

    boolean add(lk.ijse.pharmacy.to.Supplier supplier) throws ConstraintViolationException, SQLException, ClassNotFoundException;

    ArrayList<lk.ijse.pharmacy.to.Supplier> getAll() throws SQLException, ClassNotFoundException;

    lk.ijse.pharmacy.to.Supplier search(String sId) throws SQLException, ClassNotFoundException;

    boolean update(Supplier supplier) throws SQLException, ClassNotFoundException;

    boolean delete(String sId) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException;
}
