package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.entity.OrderDetails;

import java.sql.SQLException;

public interface MedicationDAO extends CrudDAO<Medication,String> {

    boolean add(Medication medication) throws ConstraintViolationException, SQLException, ClassNotFoundException;

}
