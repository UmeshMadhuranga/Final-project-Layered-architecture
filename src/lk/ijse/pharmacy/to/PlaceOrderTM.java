package lk.ijse.pharmacy.to;

import javafx.scene.control.Button;

public class PlaceOrderTM {
    String code;
    String description;
    int qty;
    double unitPrice;
    double total;
    Button button;

    public PlaceOrderTM() {
    }

    public PlaceOrderTM(String code, int qty) {
        this.code = code;
        this.qty = qty;
    }

    public PlaceOrderTM(String code, String description, int qty, double unitPrice, double total, Button button) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.button = button;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
