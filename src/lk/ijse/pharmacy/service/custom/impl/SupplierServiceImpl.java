package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.SupplierService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierServiceImpl implements SupplierService {
    private Connection connection;
    private SupplierDAO supplierDAO;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.supplierDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.SUPPLIER);
        convertor = new Convertor();
    }

    @Override
    public boolean addSupplier(Supplier supplier) throws DuplicateException, InUseException, SQLException, ClassNotFoundException {
        return supplierDAO.add(supplier);
    }

    @Override
    public boolean deleteSupplier(String sId) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(sId);
    }

    @Override
    public Supplier searchSupplier(String sId) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(sId);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(convertor.fromTSupplier(supplier));
    }

    @Override
    public ArrayList<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAll();
    }

    @Override
    public ArrayList<String> loadSupplierIDs() throws SQLException, ClassNotFoundException {
        return null;
    }
}
