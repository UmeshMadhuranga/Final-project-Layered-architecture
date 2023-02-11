package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.dto.SupplierDTO;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier,String> {

}
