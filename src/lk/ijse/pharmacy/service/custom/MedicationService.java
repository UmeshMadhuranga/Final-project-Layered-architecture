package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.dto.MedicationDTO;
import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MedicationService extends SuperService {

    boolean addMedication(MedicationDTO medicationDTO) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;

    boolean deleteMedication(String code) throws SQLException, ClassNotFoundException;

    MedicationDTO searchMedication(String code) throws SQLException, ClassNotFoundException;

    boolean updateMedication(MedicationDTO medicationDTO) throws SQLException, ClassNotFoundException;

    ArrayList<MedicationDTO> getAllMedication() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadMedicationCodes() throws SQLException, ClassNotFoundException;

}
