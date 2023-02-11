package lk.ijse.pharmacy.service.custom.impl;

import lk.ijse.pharmacy.dao.DaoFactory;
import lk.ijse.pharmacy.dao.DaoTypes;
import lk.ijse.pharmacy.dao.custom.MedicationDAO;
import lk.ijse.pharmacy.dao.custom.OrdersDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.service.custom.OrdersService;
import lk.ijse.pharmacy.service.util.Convertor;

import java.sql.Connection;
import java.sql.SQLException;

public class OrdersServiceImpl implements OrdersService {
    private Connection connection;
    private OrdersDAO ordersDAO;
    private Convertor convertor;

    public void initializer() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
        this.ordersDAO = DaoFactory.getInstance().getDAO(connection, DaoTypes.ORDERS);
        convertor = new Convertor();
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return ordersDAO.generateOrderId();
    }
}
