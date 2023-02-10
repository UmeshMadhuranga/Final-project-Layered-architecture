package lk.ijse.pharmacy.dto;

import java.util.Date;

public class MedicationDTO {
    private String mCode;
    private String description;
    private Date expirationDate;
    private int qty;
    private Double price;

    public MedicationDTO() {
    }

    public MedicationDTO(String mCode, String description, Date expirationDate, int qty, Double price) {
        this.mCode = mCode;
        this.description = description;
        this.expirationDate = expirationDate;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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
        return "MedicationDTO{" +
                "mCode='" + mCode + '\'' +
                ", description='" + description + '\'' +
                ", expirationDate=" + expirationDate +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
