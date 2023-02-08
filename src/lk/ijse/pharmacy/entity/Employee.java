package lk.ijse.pharmacy.entity;

public class Employee implements SuperEntity{
    private String emId;
    private String name;
    private String email;
    private String address;
    private int phone;

    public Employee(String emID, String name, String email, String phone) {
    }

    public Employee(String emId, String name, String email, String address, int phone) {
        this.emId = emId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId;
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
        return "Employee{" +
                "emId='" + emId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
