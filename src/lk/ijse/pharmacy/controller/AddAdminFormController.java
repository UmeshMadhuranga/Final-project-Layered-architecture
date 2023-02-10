package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.to.Admin;

import java.util.regex.Pattern;

public class AddAdminFormController {

    public JFXTextField txtUserID;
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPassword;
    public ToggleGroup radiobtnGroup;

    private Pattern userIdPattern;
    private Pattern userNamePattern;
    private Pattern emailPattern;
    private Pattern addressPattern;
    private Pattern passwordPattern;

    public AdminService adminService;

    public void initialize(){
        userIdPattern = Pattern.compile("^([U0]{2})([0-9]{2})$");
        userNamePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        passwordPattern = Pattern.compile("^([0-9]{4})$");

        this.adminService = ServiceFactory.getInstance().getService(ServiceTypes.ADMIN);
    }

    public void txtUserIDOnAction(ActionEvent actionEvent) {
        boolean isUserIdMatched = userIdPattern.matcher(txtUserID.getText()).matches();
        if (!isUserIdMatched) {
            txtUserID.setFocusColor(Paint.valueOf("Red"));
            txtUserID.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid User ID.").show();
        } else {
            txtUserName.requestFocus();
        }
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        boolean isUserNameMatched = userNamePattern.matcher(txtUserName.getText()).matches();
        if (!isUserNameMatched) {
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            txtUserName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid User Name.").show();
        } else {
            txtEmail.requestFocus();
        }
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        boolean isEmailMatched = emailPattern.matcher(txtEmail.getText()).matches();
        if (!isEmailMatched) {
            txtEmail.setFocusColor(Paint.valueOf("Red"));
            txtEmail.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Email Address.").show();
        } else {
            txtAddress.requestFocus();
        }
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        boolean isAddressMatched = addressPattern.matcher(txtAddress.getText()).matches();
        if (!isAddressMatched) {
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            txtAddress.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Address.").show();
        } else {
            txtPassword.requestFocus();
        }
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
        boolean isPasswordMatched = passwordPattern.matcher(txtPassword.getText()).matches();
        if (!isPasswordMatched) {
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            txtPassword.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Password.").show();
        }
        btnAddUserOnAction(actionEvent);
    }

    public void btnAddUserOnAction(ActionEvent actionEvent) {
        if (!(txtPassword.getText().matches("^([0-9]{4})$"))) {
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            txtPassword.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Password.").show();
            return;
        } else if (txtUserID.getText().equals("") || txtUserName.getText().equals("") ||
                txtEmail.getText().equals("") || txtAddress.getText().equals("") ||
                txtPassword.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String userId = txtUserID.getText();
        String userName = txtUserName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        RadioButton selectedToggle = (RadioButton) radiobtnGroup.getSelectedToggle();

        String role = selectedToggle.getText();
        String password = txtPassword.getText();

        AdminDTO adminDTO = new AdminDTO(userId,userName,email,address,role,password);
        if (adminService.addAdmin(adminDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
        }

 /*       try {
            boolean isAdded = AdminModel.addNewUser(admin);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

 */
        clearText();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    public void clearText(){
        txtUserID.clear();
        txtUserName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPassword.clear();
    }

    public void txtUserNameOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtUserID.getText().matches("^([U0]{2})([0-9]{2})$"))) {
            txtUserID.setFocusColor(Paint.valueOf("Red"));
            txtUserID.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid User ID.").show();
        } else {
            txtUserName.requestFocus();
        }
    }

    public void txtEmailOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtUserName.getText().matches("^([\\w\\s\\D][^0-9]{1,})$"))) {
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            txtUserName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid User Name.").show();
        } else {
            txtEmail.requestFocus();
        }
    }

    public void txtAddressOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtEmail.getText().matches("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$"))) {
            txtEmail.setFocusColor(Paint.valueOf("Red"));
            txtEmail.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Email address.").show();
        } else {
            txtAddress.requestFocus();
        }
    }

    public void txtPasswordOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtAddress.getText().matches("^([A-Za-z0-9\\W\\s]{2,})$"))) {
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            txtAddress.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Address.").show();
        } else {
            txtPassword.requestFocus();
        }
    }
}

// Done
// Regex