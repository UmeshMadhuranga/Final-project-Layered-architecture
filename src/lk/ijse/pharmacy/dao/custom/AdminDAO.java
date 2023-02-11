package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.exception.ConstraintViolationException;
import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.entity.Admin;
import lk.ijse.pharmacy.entity.SuperEntity;
import lk.ijse.pharmacy.service.exception.DuplicateException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO extends CrudDAO<Admin,String> {

    public ResultSet searchEmail(Admin admin) throws SQLException, ClassNotFoundException;

}
