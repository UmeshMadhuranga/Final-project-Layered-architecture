package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.CartDetails;
import lk.ijse.pharmacy.to.Medication;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicationModel {
    public static boolean addNewMedication(String code, String description, Date ex_date, int qty, Double price) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO medication VALUES (?,?,?,?,?);";
        return CrudUtil.execute(sql,code,description,ex_date,qty,price);
    }

    public static ArrayList<Medication> getAllMedication() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM medication");

        ArrayList<Medication> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new Medication(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5))
            );
        }
        return list;
    }

    public static Medication searchMedication(String mCode) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM medication WHERE mCode = ? ",mCode);

        while (resultSet.next()){
            return new Medication(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5));
        }
        return null;
    }

    public static boolean updateMedication(Medication medication) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE medication SET description=?, expiration_Date=?, qty=?, price=? WHERE mCode=?",
                medication.getDescription(),
                medication.getExpirationDate(),
                medication.getQty(),
                medication.getPrice(),
                medication.getMCode()
        );
    }

    public static boolean deleteMedication(String mCode) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM medication WHERE mCode = ?",mCode);
    }

    public static boolean updateMedication(ArrayList<CartDetails> list) throws SQLException, ClassNotFoundException {
        CartDetails cartDetails = null;
        for (CartDetails details : list) {
            cartDetails = new CartDetails(details.getCode(), details.getQty());
        }
        return CrudUtil.execute("UPDATE medication SET qty=qty-? WHERE mCode = ?",
                cartDetails.getQty(),cartDetails.getCode());
    }
}
