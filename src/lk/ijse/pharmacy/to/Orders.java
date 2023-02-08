package lk.ijse.pharmacy.to;

import java.time.LocalDate;
import java.util.Date;

public class Orders {
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

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getcId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }
}
