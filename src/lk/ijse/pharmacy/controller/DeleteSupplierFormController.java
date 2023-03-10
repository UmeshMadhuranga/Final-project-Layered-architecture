package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.dto.SupplierDTO;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.SupplierService;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Supplier;

import java.sql.SQLException;

public class DeleteSupplierFormController {
    public JFXTextField txtSId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtPhone;

    private SupplierService supplierService;

    public void initialize(){
        this.supplierService = ServiceFactory.getInstance().getService(ServiceTypes.SUPPLIER);
    }

    public void txtSIdOnAction(ActionEvent actionEvent) {
        if (txtSId.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING,"Please enter ID.").show();
        }

        try {
            SupplierDTO supplier = supplierService.searchSupplier(txtSId.getText());
            if (supplier == null) {
                new Alert(Alert.AlertType.WARNING, "Supplier Not Found!").show();
            } else {
                txtName.setText(supplier.getName());
                txtEmail.setText(supplier.getEmail());
                txtAddress.setText(supplier.getAddress());
                txtPhone.setText(supplier.getPhone()+"");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            Supplier supplier = SupplierModel.searchSupplier(txtSId.getText());
//            if (supplier == null) {
//                new Alert(Alert.AlertType.WARNING, "Supplier Not Found!").show();
//            } else {
//                txtName.setText(supplier.getName());
//                txtEmail.setText(supplier.getEmail());
//                txtAddress.setText(supplier.getAddress());
//                txtPhone.setText(supplier.getPhone()+"");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        btnDeleteOnAction(actionEvent);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String sId = txtSId.getText();

        try {
            boolean isDeleted = supplierService.deleteSupplier(sId);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Delete successful.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isDelete = SupplierModel.deleteSupplier(sId);
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
        txtSId.clear();
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtPhone.clear();
    }
}

// Done