package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;

import java.sql.SQLException;

public interface OrdersService extends SuperService {
    String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
