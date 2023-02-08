package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminModel {

    public static boolean addNewUser(Admin admin) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO admin VALUES (?,?,?,?,?,?);";
        return CrudUtil.execute(sql,admin.getUId(),admin.getName(),admin
                .getEmail(),admin.getAddress(),admin.getRole(),admin.getPassword());
    }

    public static ArrayList<Admin> getAllAdmin() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM admin");

        ArrayList<Admin> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new Admin(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6))
            );
        }
        return list;
    }

    public static Admin searchAdmin(String uId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM admin WHERE uId = ? ",uId);

        while (resultSet.next()){
            return new Admin(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    public static boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE admin SET name=?, email=?, address=?, role=?, password=? WHERE uId = ?;",
                admin.getName(),
                admin.getEmail(),
                admin.getAddress(),
                admin.getRole(),
                admin.getPassword(),
                admin.getUId()
        );
    }

    public static boolean deleteAdmin(String uId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM admin WHERE uId = ?",uId);
    }

    public static ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT uId FROM admin");

        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
