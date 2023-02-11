package lk.ijse.pharmacy.dto;

public class AdminDTO {
    private String uId;
    private String name;
    private String email;
    private String address;
    private String role;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String role) {
        this.role = role;
    }

    public AdminDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AdminDTO(String name, String email, String address, String role, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    public AdminDTO(String uId, String name, String email, String address, String role, String password) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "uId='" + uId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
