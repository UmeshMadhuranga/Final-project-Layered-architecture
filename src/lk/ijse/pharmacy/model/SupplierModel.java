package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public static boolean addNewSupplier(String sId, String name, String email, String address, String phone) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO supplier VALUES (?,?,?,?,?);";
        return CrudUtil.execute(sql,sId,name,email,address,phone);
    }

    public static ArrayList<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM supplier");

        ArrayList<Supplier> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new Supplier(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5))
            );
        }
        return list;
    }

    public static Supplier searchSupplier(String sId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM supplier WHERE sId = ? ",sId);

        while (resultSet.next()){
            return new Supplier(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );

        }
        return null;
    }

    public static boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE supplier SET name=?, email=?, address=?, phone=? WHERE sId = ?;",
                supplier.getName(),
                supplier.getEmail(),
                supplier.getAddress(),
                supplier.getPhone(),
                supplier.getSId()
        );
    }

    public static boolean deleteSupplier(String sId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM supplier WHERE sId = ?",sId);
    }
}
