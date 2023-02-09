package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminService extends SuperService {

    boolean addAdmin(Admin admin);

    boolean deleteAdmin(String id) throws InUseException, DuplicateException, SQLException, ClassNotFoundException;

    Admin searchAdmin(String id) throws SQLException, ClassNotFoundException;

    boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException;

    ArrayList<Admin> getAllAdmins() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadAdminIDs() throws SQLException, ClassNotFoundException;

    boolean searchAdminEmail(Admin admin) throws SQLException, ClassNotFoundException;
}
