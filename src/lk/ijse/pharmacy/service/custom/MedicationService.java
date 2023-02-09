package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Medication;

import java.sql.SQLException;

public interface MedicationService extends SuperService {

    boolean addMedication(Medication medication) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;

}
