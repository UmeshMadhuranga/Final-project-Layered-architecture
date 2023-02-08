package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.AdminDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Admin;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;
    private Connection connection;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.adminDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.ADMIN);
        convertor = new Convertor();
    }

    @Override
    public boolean addAdmin(Admin admin) throws DuplicateException {
        return adminDAO.add(convertor.fromEAdmin(admin));
    }
}
