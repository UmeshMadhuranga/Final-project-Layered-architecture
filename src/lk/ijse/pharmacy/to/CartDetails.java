package lk.ijse.pharmacy.to;

import java.util.ArrayList;

public class CartDetails {

    String code;
    String qty;

    public CartDetails() {
    }

    public CartDetails(String code, String qty) {
        this.code = code;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
