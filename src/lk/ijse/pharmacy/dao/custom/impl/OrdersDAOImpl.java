package lk.ijse.pharmacy.dao.custom.impl;

import lk.ijse.pharmacy.dao.custom.OrdersDAO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAOImpl implements OrdersDAO {

    private final Connection connection;

    public OrdersDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String generateOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT oId FROM orders ORDER BY oId DESC LIMIT 1");
        if (resultSet.next()) {
            return generateNextOrderId(resultSet.getString(1));
        }
        return generateNextOrderId(resultSet.getString(null));
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("P0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "P0" + id;
        } else {
            return "P001";
        }
    }
}
