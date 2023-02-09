package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.EmployeeService;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UpdateEmployeeFormController {
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;
    public JFXComboBox cmbEmId;

    private Pattern emIdPattern;
    private Pattern namePattern;
    private Pattern emailPattern;
    private Pattern addressPattern;
    private Pattern phonePattern;

    private EmployeeService employeeService;

    public void initialize(){
        emIdPattern = Pattern.compile("^([E0]{2})([0-9]{2})$");
        namePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        phonePattern = Pattern.compile("^([0-9]{10})$");

        LoadEmployeeID();
        this.employeeService = ServiceFactory.getInstance().getService(ServiceTypes.EMPLOYEE);
    }

    private void LoadEmployeeID() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {
            ArrayList<String> list = employeeService.loadEmployeeIDs();
            for (String id : list) {
                observableList.add(id);
            }
            cmbEmId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            ObservableList<String> observableList = FXCollections.observableArrayList();
//            ArrayList<String> idList = EmployeeModel.loadEmployeeIDs();
//
//            for (String id : idList) {
//                observableList.add(id);
//            }
//            cmbEmId.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        boolean isNameMatched = namePattern.matcher(txtName.getText()).matches();
        if (!isNameMatched) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid employee Name.").show();
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
            txtPhone.requestFocus();
        }
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        boolean isPhoneMatched = phonePattern.matcher(txtPhone.getText()).matches();
        if (!isPhoneMatched) {
            txtPhone.setFocusColor(Paint.valueOf("Red"));
            txtPhone.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Password.").show();
        } else {
            btnUpdateEmployeeOnAction(actionEvent);
        }
    }

    public void btnUpdateEmployeeOnAction(ActionEvent actionEvent) {
        if (txtName.getText().equals("") || txtEmail.getText().equals("")
                || txtAddress.getText().equals("") || txtPhone.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String emId = String.valueOf(cmbEmId.getValue());
        String name = txtName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        Employee employee = new Employee(emId,name,email,address,phone);
        try {
            boolean isUpdated = employeeService.updateEmployee(employee);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isAdded = EmployeeModel.updateEmployee(employee);
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
        txtEmail.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    public void cmbEmIdOnAction(ActionEvent actionEvent) {
        String id =String.valueOf(cmbEmId.getValue());
        try {
            Employee employee = employeeService.searchEmployee(id);
            fillTheFields(employee);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            Employee employee = EmployeeModel.searchEmployee(id);
//            fillTheFields(employee);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void fillTheFields(Employee employee) {
        txtName.setText(employee.getName());
        txtEmail.setText(employee.getEmail());
        txtAddress.setText(employee.getAddress());
        txtPhone.setText(employee.getPhone());
    }
}

// Done
// Regex