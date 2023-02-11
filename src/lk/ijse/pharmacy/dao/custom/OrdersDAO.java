package lk.ijse.pharmacy.dao.custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.OrderDetails;
import lk.ijse.pharmacy.entity.Orders;

import java.sql.SQLException;

public interface OrdersDAO extends CrudDAO<Orders,String> {
    String generateOrderId() throws SQLException, ClassNotFoundException;
}
