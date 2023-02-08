package lk.ijse.pharmacy.entity;

import java.util.Date;

public class Orders implements SuperEntity{
    private String oId;
    private Date date;
    private String cId;

    public Orders() {
    }

    public Orders(String oId, Date date, String cId) {
        this.oId = oId;
        this.date = date;
        this.cId = cId;
    }

    public String getOId() {
        return oId;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oId='" + oId + '\'' +
                ", date=" + date +
                ", cId='" + cId + '\'' +
                '}';
    }
}
