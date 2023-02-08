package lk.ijse.pharmacy.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pharmacy.dao.Util.DBUtil;
import lk.ijse.pharmacy.dao.custom.AdminDAO;
import lk.ijse.pharmacy.entity.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {

    private final Connection connection;

    public AdminDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(Admin admin) {
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
    public ArrayList<lk.ijse.pharmacy.to.Admin> getAll() {
        return null;
    }

    @Override
    public lk.ijse.pharmacy.to.Admin search(String uId) {
        return null;
    }

    @Override
    public boolean update(lk.ijse.pharmacy.to.Admin admin) {
        return false;
    }

    @Override
    public boolean delete(String uId) {
        return false;
    }

    @Override
    public ArrayList<String> loadIDs() {
        return null;
    }
}
