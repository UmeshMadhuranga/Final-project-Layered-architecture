package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.to.Medication;

import java.sql.SQLException;

public class DeleteMedicationFormController {
    public JFXTextField txtMCode;
    public JFXTextField txtDescription;
    public JFXTextField txtExpirationDate;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;

    public void txtMCodeOnAction(ActionEvent actionEvent) {
        if (txtMCode.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING,"Please enter ID.").show();
        }
        try {
            Medication medication = MedicationModel.searchMedication(txtMCode.getText());
            if (medication == null) {
                new Alert(Alert.AlertType.WARNING, "Medication Not Found!").show();
            } else {
                txtDescription.setText(medication.getDescription());
                txtExpirationDate.setText(medication.getExpirationDate()+"");
                txtQty.setText(medication.getQty()+"");
                txtPrice.setText(medication.getPrice()+"");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void txtDescriptionOnAction(ActionEvent actionEvent) {
        txtExpirationDate.requestFocus();
    }

    public void txtExpirationDateOnAction(ActionEvent actionEvent) {
        txtQty.requestFocus();
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }

    public void txtPriceOnAction(ActionEvent actionEvent) {
        btnDeleteOnAction(actionEvent);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String mCode = txtMCode.getText();

        try {
            boolean isDelete = MedicationModel.deleteMedication(mCode);
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

    private void clearText() {
        txtMCode.clear();
        txtDescription.clear();
        txtExpirationDate.clear();
        txtQty.clear();
        txtPrice.clear();
    }
}

//  Done