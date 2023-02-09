package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.EmployeeService;
import lk.ijse.pharmacy.to.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteEmployeeFormController {
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;
    public JFXComboBox cmbEmId;

    private EmployeeService employeeService;

    public void initialize(){
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
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String emId = String.valueOf(cmbEmId.getValue());
        try {
            boolean isDelete = employeeService.deleteEmployee(emId);
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isDelete = EmployeeModel.deleteEmployee(emId);
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

//  Done