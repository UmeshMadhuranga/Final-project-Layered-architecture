package lk.ijse.pharmacy.entity;

import java.util.Date;

public class Medication implements SuperEntity{
    private String mCode;
    private String description;
    private Date expiration_Date;
    private int qty;
    private Double price;

    public Medication() {
    }

    public Medication(String mCode, String description, Date expiration_Date, int qty, Double price) {
        this.mCode = mCode;
        this.description = description;
        this.expiration_Date = expiration_Date;
        this.qty = qty;
        this.price = price;
    }

    public String getMCode() {
        return mCode;
    }

    public void setMCode(String mCode) {
        this.mCode = mCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration_Date() {
        return expiration_Date;
    }

    public void setExpiration_Date(Date expiration_Date) {
        this.expiration_Date = expiration_Date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "mCode='" + mCode + '\'' +
                ", description='" + description + '\'' +
                ", expiration_Date=" + expiration_Date +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
