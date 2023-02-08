package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.to.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DeleteCustomerFormController {
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;
    public JFXComboBox cmbCId;

    public void initialize(){
        LoadCustomerID();
    }

    private void LoadCustomerID() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = CustomerModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        btnDeleteCustomerOnAction(actionEvent);
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean isDelete = CustomerModel.deleteCustomer(String.valueOf(cmbCId.getValue()));
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        clearText();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    public void cmbCIdOnAction(ActionEvent actionEvent) {
        String id =String.valueOf(cmbCId.getValue());

        try {
            Customer customer = CustomerModel.searchCustomer(id);
            fillTheFields(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fillTheFields(Customer customer) {
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtPhone.setText(customer.getPhone());
    }
}

//  Done