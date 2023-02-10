package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.AdminDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;
    private Connection connection;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.adminDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.ADMIN);
        convertor = new Convertor();
    }


//    public boolean addAdmin(Admin admin) throws DuplicateException {
//        return adminDAO.add(convertor.fromEAdmin(admin));
//    }

    @Override
    public boolean addAdmin(AdminDTO adminDTO) {
        return adminDAO.add(convertor.toAdmin(adminDTO));
    }

    @Override
    public boolean deleteAdmin(String id) throws InUseException, DuplicateException, SQLException, ClassNotFoundException {
        return adminDAO.delete(id);
    }

    @Override
    public AdminDTO searchAdmin(String id) throws SQLException, ClassNotFoundException {
        return convertor.fromAdmin(adminDAO.search(id));
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) throws SQLException, ClassNotFoundException {
        return adminDAO.update(convertor.toAdmin(adminDTO));
    }


//    public boolean updateAdmin(Admin admin) throws SQLException, ClassNotFoundException {
//        return adminDAO.update(convertor.fromAdmin(admin));
//    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() throws SQLException, ClassNotFoundException {
        return adminDAO.getAll();
    }

    @Override
    public ArrayList<String> loadAdminIDs() throws SQLException, ClassNotFoundException {
        return adminDAO.loadIDs();
    }

    @Override
    public boolean searchAdminEmail(AdminDTO adminDTO) throws SQLException, ClassNotFoundException {
        return adminDAO.searchEmail(convertor.toAdmin(adminDTO));
    }

//    @Override
//    public boolean searchAdminEmail(Admin admin) throws SQLException, ClassNotFoundException {
//        return adminDAO.searchEmail(convertor.fromEAdmin(admin));
//    }
}
