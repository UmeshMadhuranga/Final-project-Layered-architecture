package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.MedicationDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.MedicationDTO;
import lk.ijse.pharmacy.service.custom.MedicationService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Medication;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicationServiceImpl implements MedicationService {
    private Connection connection;
    private MedicationDAO medicationDAO;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.medicationDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.MEDICATION);
        convertor = new Convertor();
    }

    @Override
    public boolean addMedication(MedicationDTO medicationDTO) throws DuplicateException, InUseException, SQLException, ClassNotFoundException {
        return medicationDAO.add(convertor.toMedication(medicationDTO));
    }

    @Override
    public boolean deleteMedication(String code) throws SQLException, ClassNotFoundException {
        return medicationDAO.delete(code);
    }

    @Override
    public MedicationDTO searchMedication(String code) throws SQLException, ClassNotFoundException {
        return convertor.fromMedication(medicationDAO.search(code));
    }

    @Override
    public boolean updateMedication(MedicationDTO medicationDTO) throws SQLException, ClassNotFoundException {
        return medicationDAO.update(convertor.toMedication(medicationDTO));
    }

    @Override
    public ArrayList<MedicationDTO> getAllMedication() throws SQLException, ClassNotFoundException {
        return medicationDAO.getAll();
    }

    @Override
    public ArrayList<String> loadMedicationCodes() throws SQLException, ClassNotFoundException {
        return null;
    }
}
