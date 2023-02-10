package lk.ijse.pharmacy.dto;

public class CartDetailsDTO {
    private String code;
    private String qty;

    public CartDetailsDTO() {
    }

    public CartDetailsDTO(String code, String qty) {
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

    @Override
    public String toString() {
        return "CartDetailsDTO{" +
                "code='" + code + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
