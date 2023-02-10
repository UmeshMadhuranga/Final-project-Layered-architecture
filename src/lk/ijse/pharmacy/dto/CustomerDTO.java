package lk.ijse.pharmacy.dto;

public class CustomerDTO {
    private String cId;
    private String name;
    private String address;
    private String phone;

    public CustomerDTO(String cId, String name, String address, int phone) {
    }

    public CustomerDTO(String cId, String name, String address, String phone) {
        this.cId = cId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "CustomerDTO{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
