package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.service.exception.DuplicateException;
import lk.ijse.pharmacy.service.exception.InUseException;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;

public interface SupplierService extends SuperService {

    boolean addSupplier(Supplier supplier) throws DuplicateException, InUseException, SQLException, ClassNotFoundException;

}
