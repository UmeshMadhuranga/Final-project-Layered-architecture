package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.to.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DeleteAdminFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXComboBox cmbUserID;

    public void initialize(){
        LoadUserID();
    }

    private void LoadUserID() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = AdminModel.loadIDs();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbUserID.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
            boolean isDelete = AdminModel.deleteAdmin(uId);
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
            Admin admin = AdminModel.searchAdmin(id);
            fillTheFields(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fillTheFields(Admin admin) {
        txtUserName.setText(admin.getName());
        txtEmail.setText(admin.getEmail());
        txtAddress.setText(admin.getAddress());
    }
}

//  Done