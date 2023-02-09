package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.CustomerService;
import lk.ijse.pharmacy.to.Customer;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddCustomerFormController {
    public JFXTextField txtCustomerId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;

    private Pattern customerIdPattern;
    private Pattern namePattern;
    private Pattern addressPattern;
    private Pattern phonePattern;

    public CustomerService customerService;

    public void initialize(){
        customerIdPattern = Pattern.compile("^([C0]{2})([0-9]{2})$");
        namePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        phonePattern = Pattern.compile("^([0-9]{10})$");

        customerService = ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);
    }

    public void txtCustomerIdOnAction(ActionEvent actionEvent) {
        boolean isCustomerIdMatched = customerIdPattern.matcher(txtCustomerId.getText()).matches();
        if (!isCustomerIdMatched) {
            txtCustomerId.setFocusColor(Paint.valueOf("Red"));
            txtCustomerId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Customer ID.").show();
        } else {
            txtName.requestFocus();
        }
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
            btnAddCustomerOnAction(actionEvent);
        }
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        if (!(txtPhone.getText().matches("^([0-9]{10})$"))) {
            txtPhone.setFocusColor(Paint.valueOf("Red"));
            txtPhone.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Phone Number.").show();
            return;
        } else if (txtCustomerId.getText().equals("") || txtName.getText().equals("") ||
                txtAddress.getText().equals("") || txtPhone.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String cId = txtCustomerId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        Customer customer = new Customer(cId,name,address,phone);
        try {
            if (customerService.addCustomer(customer)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
        }
//        try {
//            boolean isAdded = CustomerModel.addNewCustomer(cId,name,address,phone);
//            if (isAdded) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
//            }
//            clearText();
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        clearText();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtCustomerId.clear();
        txtName.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    public void txtCustomerNameMouseOnClicked(MouseEvent mouseEvent) {
        if (!(txtCustomerId.getText().matches("^([C0]{2})([0-9]{2})$"))) {
            txtCustomerId.setFocusColor(Paint.valueOf("Red"));
            txtCustomerId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Customer ID.").show();
        } else {
            txtName.requestFocus();
        }
    }

    public void txtAddressMouseOnClicked(MouseEvent mouseEvent) {
        if (!(txtName.getText().matches("^([\\w\\s\\D][^0-9]{1,})$"))) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Customer Name.").show();
        } else {
            txtAddress.requestFocus();
        }
    }

    public void txtPhoneMouseOnClicked(MouseEvent mouseEvent) {
        if (!(txtAddress.getText().matches("^([A-Za-z0-9\\W\\s]{2,})$"))) {
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            txtAddress.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Address.").show();
        } else {
            txtPhone.requestFocus();
        }
    }
}

//Done
//Regex