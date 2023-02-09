package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.to.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DeleteAdminFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXComboBox cmbUserID;

    private AdminService adminService;

    public void initialize(){
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
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteUserOnAction(ActionEvent actionEvent) {
        String uId = String.valueOf(cmbUserID.getValue());

        try {
            boolean isDelete = adminService.deleteAdmin(uId);
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isDelete = AdminModel.deleteAdmin(uId);
//            if (isDelete) {
//                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
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
    }
}

//  Done