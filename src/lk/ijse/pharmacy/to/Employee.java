package lk.ijse.pharmacy.to;

public class Employee {
    private String emID;
    private String name;
    private String email;
    private String address;
    private String phone;

    public Employee(String emId, String name, String email, int phone) {
    }

    public Employee(String emID, String name, String email, String address, String phone) {
        this.emID = emID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getEmID() {
        return emID;
    }

    public void setEmID(String emID) {
        this.emID = emID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
