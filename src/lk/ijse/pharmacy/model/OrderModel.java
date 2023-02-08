package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.to.Orders;
import lk.ijse.pharmacy.to.PlaceOrder;
import lk.ijse.pharmacy.to.PlaceOrderTM;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderModel {
    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
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

    public static boolean addOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrders = OrderModel.addOrder1(placeOrder);
            if (isOrders){
                boolean orderDetail = PlaceOrderModel.addOrderDetail(placeOrder.getOderId(), placeOrder.getList());
                if (orderDetail){
                    boolean isUpdated = MedicationModel.updateMedication(placeOrder.getList());
                    if (isUpdated) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;
    }

    private static boolean addOrder1(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO orders VALUES(?,?,?)",
                placeOrder.getOderId(), LocalDate.now(), placeOrder.getCustomerId());
    }
}
