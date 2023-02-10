package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.dto.CustomerDTO;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.CustomerService;
import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.to.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UpdateCustomerFormController {
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;
    public JFXComboBox txtCId;

    private Pattern customerIdPattern;
    private Pattern namePattern;
    private Pattern addressPattern;
    private Pattern phonePattern;

    private CustomerService customerService;

    public void initialize(){
        customerIdPattern = Pattern.compile("^([C0]{2})([0-9]{2})$");
        namePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        phonePattern = Pattern.compile("^([0-9]{10})$");

        LoadCustomerID();
        this.customerService = ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);
    }

    private void LoadCustomerID() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {
            ArrayList<String> list = customerService.loadCustomerIDs();
            for (String id : list) {
                observableList.add(id);
            }
            txtCId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            ObservableList<String> observableList = FXCollections.observableArrayList();
//            ArrayList<String> idList = CustomerModel.loadCustomerIds();
//
//            for (String id : idList) {
//                observableList.add(id);
//            }
//            txtCId.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void txtCIdOnAction(ActionEvent actionEvent) {
        String id =String.valueOf(txtCId.getValue());
        try {
            CustomerDTO customer = customerService.searchCustomer(id);
            fillTheFields(customer);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            Customer customer = CustomerModel.searchCustomer(id);
//            fillTheFields(customer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void fillTheFields(CustomerDTO customer) {
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtPhone.setText(customer.getPhone());
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        boolean isNameMatched = namePattern.matcher(txtName.getText()).matches();
        if (!isNameMatched) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Customer Name.").show();
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
            txtPhone.requestFocus();
        }
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        boolean isPhonedMatched = phonePattern.matcher(txtPhone.getText()).matches();
        if (!isPhonedMatched) {
            txtPhone.setFocusColor(Paint.valueOf("Red"));
            txtPhone.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Password.").show();
        } else {
            btnUpdateOnAction(actionEvent);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (txtCId.getValue().equals("") || txtName.getText().equals("") ||
                txtAddress.getText().equals("") || txtPhone.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String cId = String.valueOf(txtCId.getValue());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        CustomerDTO customerDTO = new CustomerDTO(cId,name,address,phone);
        try {
            boolean isUpdated = customerService.updateCustomer(customerDTO);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isAdded = CustomerModel.updateCustomer(customer);
//            if (isAdded) {
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

    private void clearText() {
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
    }
}

//  Done
//  Regex