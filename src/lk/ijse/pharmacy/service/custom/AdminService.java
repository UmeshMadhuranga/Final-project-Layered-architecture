package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminService extends SuperService {

    boolean addAdmin(AdminDTO adminDTO);

    boolean deleteAdmin(String id) throws InUseException, DuplicateException, SQLException, ClassNotFoundException;

    AdminDTO searchAdmin(String id) throws SQLException, ClassNotFoundException;

    boolean updateAdmin(AdminDTO adminDTO) throws SQLException, ClassNotFoundException;

    ArrayList<AdminDTO> getAllAdmins() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadAdminIDs() throws SQLException, ClassNotFoundException;

    boolean searchAdminEmail(AdminDTO admin) throws SQLException, ClassNotFoundException;
}
