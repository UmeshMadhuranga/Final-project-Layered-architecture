package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.SupplierDTO;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.service.custom.SupplierService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;

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
    public boolean addSupplier(SupplierDTO supplier) throws DuplicateException, InUseException, SQLException, ClassNotFoundException {
        return supplierDAO.add(convertor.toSupplier(supplier));
    }

    @Override
    public boolean deleteSupplier(String sId) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(sId);
    }

    @Override
    public SupplierDTO searchSupplier(String sId) throws SQLException, ClassNotFoundException {
        return convertor.fromSupplier(supplierDAO.search(sId));
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(convertor.toSupplier(supplierDTO));
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> list = new ArrayList<>();

        ArrayList<Supplier> all = supplierDAO.getAll();
        for (Supplier supplier: all) {
            list.add(convertor.fromSupplier(supplier));
        }
        return list;
    }

    @Override
    public ArrayList<String> loadSupplierIDs() throws SQLException, ClassNotFoundException {
        return null;
    }
}
