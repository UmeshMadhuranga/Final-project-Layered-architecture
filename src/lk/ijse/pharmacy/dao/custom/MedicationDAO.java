package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.dto.MedicationDTO;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MedicationDAO extends CrudDAO<Medication,String> {

    boolean add(Medication medication) throws ConstraintViolationException, SQLException, ClassNotFoundException;

    ArrayList<MedicationDTO> getAll() throws SQLException, ClassNotFoundException;

    Medication search(String code) throws SQLException, ClassNotFoundException;

    boolean update(Medication medication) throws SQLException, ClassNotFoundException;

    boolean delete(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadCodes() throws SQLException, ClassNotFoundException;
}
