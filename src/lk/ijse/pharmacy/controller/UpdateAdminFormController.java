package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.to.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UpdateAdminFormController {

    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPassword;
    public ToggleGroup r1btnGroup;

    public JFXComboBox cmbUserID;

    private Pattern userNamePattern;
    private Pattern emailPattern;
    private Pattern addressPattern;
    private Pattern passwordPattern;

    private AdminService adminService;

    public void initialize(){
        userNamePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        passwordPattern = Pattern.compile("^([0-9]{4})$");

        LoadUserID();
        this.adminService = ServiceFactory.getInstance().getService(ServiceTypes.ADMIN);
    }

    private void LoadUserID() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> list = adminService.loadAdminIDs();
            for (String id : list) {
                observableList.add(id);
            }
            cmbUserID.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            ObservableList<String> observableList = FXCollections.observableArrayList();
//            ArrayList<String> idList = AdminModel.loadIDs();
//
//            for (String id : idList) {
//                observableList.add(id);
//            }
//            cmbUserID.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
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
        btnUpdateUserOnAction(actionEvent);
    }

    public void btnUpdateUserOnAction(ActionEvent actionEvent) {
        if (txtUserName.getText().equals("") ||
                txtEmail.getText().equals("") || txtAddress.getText().equals("") ||
                txtPassword.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String uId = String.valueOf(cmbUserID.getValue());
        String userName = txtUserName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        RadioButton selectedToggle = (RadioButton) r1btnGroup.getSelectedToggle();

        String role = selectedToggle.getText();
        String password = txtPassword.getText();

        Admin admin = new Admin(uId,userName,email,address,role,password);
        try {
            boolean isUpdate = adminService.updateAdmin(admin);
            if (isUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isUpdate = AdminModel.updateAdmin(admin);
//            if (isUpdate) {
//                new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Something wrong").show();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        clearText();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    public void clearText(){
        txtUserName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPassword.clear();
    }

    public void cmbUserIDOnAction(ActionEvent actionEvent) {
        String id =String.valueOf(cmbUserID.getValue());

        try {
            Admin admin = adminService.searchAdmin(id);
            fillTheFields(admin);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            Admin admin = AdminModel.searchAdmin(id);
//            fillTheFields(admin);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void fillTheFields(Admin admin) {
        txtUserName.setText(admin.getName());
        txtEmail.setText(admin.getEmail());
        txtAddress.setText(admin.getAddress());
        txtPassword.setText(admin.getPassword());
    }
}

//  Done
//  Regex