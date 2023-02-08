package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public static ResultSet resultSet;

    public static boolean searchEmail(Admin admin) throws SQLException, ClassNotFoundException {
        resultSet = CrudUtil.execute("SELECT * FROM admin WHERE email = ?", admin.getEmail());
        while (resultSet.next()) {
            if (resultSet.getString(3).equals(admin.getEmail()) &&
                    resultSet.getString(6).equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
