package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.SuperEntity;
import lk.ijse.pharmacy.service.exception.DuplicateException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO extends CrudDAO<Admin,String> {

    boolean add(Admin admin) throws ConstraintViolationException;

    ArrayList<lk.ijse.pharmacy.to.Admin> getAll() throws SQLException, ClassNotFoundException;

    lk.ijse.pharmacy.to.Admin search(String uId) throws SQLException, ClassNotFoundException;

    boolean update(Admin admin) throws SQLException, ClassNotFoundException;

    boolean delete(String uId) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException;

}
