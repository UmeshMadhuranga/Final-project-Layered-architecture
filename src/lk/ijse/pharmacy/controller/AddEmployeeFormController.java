package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.EmployeeModel;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddEmployeeFormController {
    public JFXTextField txtEmployeeId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;

    private Pattern emIdPattern;
    private Pattern namePattern;
    private Pattern emailPattern;
    private Pattern addressPattern;
    private Pattern phonePattern;

    public void initialize(){
        emIdPattern = Pattern.compile("^([E0]{2})([0-9]{2})$");
        namePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        phonePattern = Pattern.compile("^([0-9]{10})$");
    }

    public void txtEmployeeIdOnAction(ActionEvent actionEvent) {
        boolean isEIdMatched = emIdPattern.matcher(txtEmployeeId.getText()).matches();
        if (!isEIdMatched) {
            txtEmployeeId.setFocusColor(Paint.valueOf("Red"));
            txtEmployeeId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid employee ID.").show();
        } else {
            txtName.requestFocus();
        }
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
            new Alert(Alert.AlertType.ERROR,"invalid Phone Number.").show();
        } else {
            btnAddEmployeeOnAction(actionEvent);
        }
    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) {
        if (!(txtPhone.getText().matches("^([0-9]{10})$"))) {
            txtPhone.setFocusColor(Paint.valueOf("Red"));
            txtPhone.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Phone Number.").show();
            return;
        } else if (txtEmployeeId.getText().equals("") || txtName.getText().equals("") ||
                txtEmail.getText().equals("") || txtAddress.getText().equals("") ||
                txtPhone.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String emId = txtEmployeeId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();

        try {
            boolean isAdded = EmployeeModel.addNewEmployee(emId,name,email,address,phone);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
            }
            clearText();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtEmployeeId.clear();
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    public void txtEmployeeNameOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtEmployeeId.getText().matches("^([E0]{2})([0-9]{2})$"))) {
            txtEmployeeId.setFocusColor(Paint.valueOf("Red"));
            txtEmployeeId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Employee ID.").show();
        } else {
            txtName.requestFocus();
        }
    }

    public void txtEmailOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtName.getText().matches("^([\\w\\s\\D][^0-9]{1,})$"))) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Employee Name.").show();
        } else {
            txtEmail.requestFocus();
        }
    }

    public void txtAddressOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtEmail.getText().matches("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$"))) {
            txtEmail.setFocusColor(Paint.valueOf("Red"));
            txtEmail.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Email Address.").show();
        } else {
            txtAddress.requestFocus();
        }
    }

    public void txtPhoneOnMouseClicked(MouseEvent mouseEvent) {
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