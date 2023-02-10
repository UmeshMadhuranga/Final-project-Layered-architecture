package lk.ijse.pharmacy.dto;

import lk.ijse.pharmacy.to.CartDetails;

import java.util.ArrayList;

public class PlaceOrderDTO {
    private String oderId;
    private String customerId;
    private ArrayList<CartDetails> list;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String oderId, String customerId, ArrayList<CartDetails> list) {
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

    @Override
    public String toString() {
        return "PlaceOrderDTO{" +
                "oderId='" + oderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", list=" + list +
                '}';
    }
}
