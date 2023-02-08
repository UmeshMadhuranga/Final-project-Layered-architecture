package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.CartDetails;
import lk.ijse.pharmacy.to.Orders;
import lk.ijse.pharmacy.to.PlaceOrder;
import lk.ijse.pharmacy.to.PlaceOrderTM;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceOrderModel {
    public static boolean addOrderDetail(String oderId, ArrayList<CartDetails> list) throws SQLException, ClassNotFoundException {
        for(CartDetails cartDetails: list){
            CartDetails details = new CartDetails(cartDetails.getCode(), cartDetails.getQty());
            if (!save(oderId,details)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String oderId, CartDetails details) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO order_details VALUES(?,?,?)",
                oderId,details.getCode(),Integer.parseInt(details.getQty()));
    }
}
