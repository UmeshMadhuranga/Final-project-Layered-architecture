package lk.ijse.pharmacy.dto;

public class EmployeeDTO {
    private String emID;
    private String name;
    private String email;
    private String address;
    private String phone;

    public EmployeeDTO(String emId, String name, String email, String phone) {
    }

    public EmployeeDTO(String emID, String name, String email, String address, String phone) {
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

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emID='" + emID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
