package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.dao.custom.SupplierDAO;
import lk.ijse.pharmacy.dto.SupplierDTO;
import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierService extends SuperService {

    boolean addSupplier(SupplierDTO supplierDAO) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;

    boolean deleteSupplier(String sId) throws SQLException, ClassNotFoundException;

    SupplierDTO searchSupplier(String sId) throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadSupplierIDs() throws SQLException, ClassNotFoundException;
}
