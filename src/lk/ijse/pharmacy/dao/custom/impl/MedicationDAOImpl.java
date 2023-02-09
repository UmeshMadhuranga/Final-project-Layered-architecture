package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.MedicationDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class MedicationDAOImpl implements MedicationDAO {

    private final Connection connection;

    public MedicationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Medication medication) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO medication VALUES (?,?,?,?,?);", medication.getMCode(), medication.getDescription(), medication.getExpiration_Date(), medication.getQty(), medication.getPrice());
    }
}
