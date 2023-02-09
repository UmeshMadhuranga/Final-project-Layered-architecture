package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.SQLException;

public interface SupplierDAO extends CrudDAO<Supplier,String> {

    boolean add(lk.ijse.pharmacy.to.Supplier supplier) throws ConstraintViolationException, SQLException, ClassNotFoundException;

}
