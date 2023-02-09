package lk.ijse.pharmacy.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.AdminDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {

    private final Connection connection;
    public static ResultSet resultSet;

    public AdminDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Admin admin) throws ConstraintViolationException {
        try {
            return DBUtil.executeUpdate("INSERT INTO admin VALUES (?,?,?,?,?,?);",
                    admin.getUId(),
                    admin.getName(),
                    admin.getName(),
                    admin.getEmail(),
                    admin.getAddress(),
                    admin.getRole(),
                    admin.getPassword());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
        }
        return false;
    }

    @Override
    public ArrayList<lk.ijse.pharmacy.to.Admin> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM admin");

        ArrayList<lk.ijse.pharmacy.to.Admin> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new lk.ijse.pharmacy.to.Admin(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6))
            );
        }
        return list;
    }

    @Override
    public lk.ijse.pharmacy.to.Admin search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DBUtil.executeQuery("SELECT * FROM admin WHERE uId = ? ", id);

        while (resultSet.next()){
            return new lk.ijse.pharmacy.to.Admin(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    @Override
    public boolean update(Admin admin) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("UPDATE admin SET name=?, email=?, address=?, role=?, password=? WHERE uId = ?;",
                admin.getName(),
                admin.getEmail(),
                admin.getAddress(),
                admin.getRole(),
                admin.getPassword(),
                admin.getUId()
        );
    }

    @Override
    public boolean delete(String uId) throws SQLException, ClassNotFoundException {
        return DBUtil.executeUpdate("DELETE FROM admin WHERE uId = ?",uId);
    }

    @Override
    public ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBUtil.executeQuery("SELECT uId FROM admin");
        ArrayList<String> idList = new ArrayList<>();

        while (rst.next()) {
            idList.add(rst.getString(1));
        }
        return idList;
    }

    @Override
    public boolean searchEmail(Admin admin) throws SQLException, ClassNotFoundException {
        resultSet = DBUtil.executeQuery("SELECT * FROM admin WHERE email = ?", admin.getEmail());
        while (resultSet.next()) {
            if (resultSet.getString(3).equals(admin.getEmail()) &&
                    resultSet.getString(6).equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
