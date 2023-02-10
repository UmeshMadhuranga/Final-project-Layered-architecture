package lk.ijse.pharmacy.dto;

public class SupplierDTO {
    private String sId;
    private String name;
    private String email;
    private String address;
    private String phone;

    public SupplierDTO(String sId, String name, String email, String address, int phone) {
    }

    public SupplierDTO(String sId, String name, String email, String address, String phone) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
