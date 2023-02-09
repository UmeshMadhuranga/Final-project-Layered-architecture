package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.MedicationDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Medication;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicationDAOImpl implements MedicationDAO {

    private final Connection connection;

    public MedicationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Medication medication) throws ConstraintViolationException, SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("INSERT INTO medication VALUES (?,?,?,?,?);", medication.getMCode(), medication.getDescription(), medication.getExpiration_Date(), medication.getQty(), medication.getPrice());
    }

    @Override
    public ArrayList<lk.ijse.pharmacy.to.Medication> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM medication");

        ArrayList<lk.ijse.pharmacy.to.Medication> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new lk.ijse.pharmacy.to.Medication(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5))
            );
        }
        return list;
    }

    @Override
    public lk.ijse.pharmacy.to.Medication search(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM medication WHERE mCode = ? ",code);

        while (resultSet.next()){
            return new lk.ijse.pharmacy.to.Medication(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5));
        }
        return null;
    }

    @Override
    public boolean update(Medication medication) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("UPDATE medication SET description=?, expiration_Date=?, qty=?, price=? WHERE mCode=?",
                medication.getDescription(),
                medication.getExpiration_Date(),
                medication.getQty(),
                medication.getPrice(),
                medication.getMCode()
        );
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("DELETE FROM medication WHERE mCode = ?",code);
    }

    @Override
    public ArrayList<String> loadCodes() throws SQLException, ClassNotFoundException {
        return null;
    }
}
