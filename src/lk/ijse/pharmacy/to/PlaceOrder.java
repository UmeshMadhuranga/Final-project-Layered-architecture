package lk.ijse.pharmacy.to;

import java.util.ArrayList;

public class PlaceOrder {
    String oderId;
    String customerId;
    ArrayList<CartDetails> list;

    public PlaceOrder() {
    }

    public PlaceOrder(String oderId, String customerId, ArrayList<CartDetails> list) {
        this.oderId = oderId;
        this.customerId = customerId;
        this.list = list;
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<CartDetails> getList() {
        return list;
    }

    public void setList(ArrayList<CartDetails> list) {
        this.list = list;
    }
}

