package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.SupplierService;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddSupplierFormController {
    public JFXTextField txtSId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;

    private Pattern sIdPattern;
    private Pattern namePattern;
    private Pattern emailPattern;
    private Pattern addressPattern;
    private Pattern phonePattern;

    private SupplierService supplierService;

    public void initialize(){
        sIdPattern = Pattern.compile("^([S0]{2})([0-9]{2})$");
        namePattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        addressPattern = Pattern.compile("^([A-Za-z0-9\\W\\s]{2,})$");
        phonePattern = Pattern.compile("^([0-9]{10})$");

        supplierService = ServiceFactory.getInstance().getService(ServiceTypes.SUPPLIER);
    }

    public void txtSIdOnAction(ActionEvent actionEvent) {
        boolean isSIdMatched = sIdPattern.matcher(txtSId.getText()).matches();
        if (!isSIdMatched) {
            txtSId.setFocusColor(Paint.valueOf("Red"));
            txtSId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Supplier ID.").show();
        } else {
            txtName.requestFocus();
        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        boolean isNameMatched = namePattern.matcher(txtName.getText()).matches();
        if (!isNameMatched) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Supplier Name.").show();
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
            new Alert(Alert.AlertType.ERROR,"invalid Phone number.").show();
        } else {
            btnAddSupplierOnAction(actionEvent);
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtSId.clear();
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPhone.clear();
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
        if (!(txtPhone.getText().matches("^([0-9]{10})$"))) {
            txtPhone.setFocusColor(Paint.valueOf("Red"));
            txtPhone.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Phone Number.").show();
            return;
        } else if (txtSId.getText().equals("") || txtName.getText().equals("") ||
                txtEmail.getText().equals("") || txtAddress.getText().equals("") ||
                txtPhone.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        } else {
            String sId = txtSId.getText();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();

            Supplier supplier = new Supplier(sId,name,email,address,phone);
            try {
                if (supplierService.addSupplier(supplier)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
                }
                clearText();
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
            }

//            try {
//                boolean isAdded = SupplierModel.addNewSupplier(sId,name,email,address,phone);
//                if (isAdded) {
//                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!").show();
//                } else {
//                    new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
//                }
//                clearText();
//            } catch (SQLException e) {
//                new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
        }

    }

    public void txtSupplierNameOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtSId.getText().matches("^([S0]{2})([0-9]{2})$"))) {
            txtSId.setFocusColor(Paint.valueOf("Red"));
            txtSId.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Supplier ID.").show();
        } else {
            txtName.requestFocus();
        }
    }

    public void txtEmailOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtName.getText().matches("^([\\w\\s\\D][^0-9]{1,})$"))) {
            txtName.setFocusColor(Paint.valueOf("Red"));
            txtName.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Supplier Name.").show();
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