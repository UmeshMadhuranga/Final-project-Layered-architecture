package lk.ijse.pharmacy.dao;

import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.SuperEntity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> extends SuperDAO{
    boolean add(T T) throws ConstraintViolationException, SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    T search(ID id) throws SQLException, ClassNotFoundException;

    boolean update(T T) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadIDs() throws SQLException, ClassNotFoundException;
}
