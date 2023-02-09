package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.MedicationDAO;
import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.SupplierService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.service.util.Convertor;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.Connection;
import java.sql.SQLException;

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
}
