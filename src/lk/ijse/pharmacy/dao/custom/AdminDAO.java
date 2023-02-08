package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.SuperEntity;
import lk.ijse.pharmacy.service.exception.DuplicateException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO extends CrudDAO<Admin,String> {
    boolean add(Admin admin) throws DuplicateException;
    ArrayList<lk.ijse.pharmacy.to.Admin> getAll();
    lk.ijse.pharmacy.to.Admin search(String uId);
    boolean update(lk.ijse.pharmacy.to.Admin admin);
    boolean delete(String uId);
    ArrayList<String> loadIDs();
}
