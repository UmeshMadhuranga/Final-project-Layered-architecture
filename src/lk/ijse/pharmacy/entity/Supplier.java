package lk.ijse.pharmacy.entity;

public class Supplier implements SuperEntity{
    private String sId;
    private String name;
    private String email;
    private String address;
    private int phone;

    public Supplier(String sId, String name, String email, String address, String phone) {
    }

    public Supplier(String sId, String name, String email, String address, int phone) {
        this.sId = sId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
