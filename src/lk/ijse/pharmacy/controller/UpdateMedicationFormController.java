package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.MedicationService;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UpdateMedicationFormController {
    public JFXTextField txtMCode;
    public JFXTextField txtDescription;
    public JFXTextField txtExpirationDate;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;

    private Pattern codePattern;
    private Pattern descriptionPattern;
    private Pattern expirationDatePattern;
    private Pattern qtyPattern;
    private Pattern pricePattern;

    private MedicationService medicationService;

    public void initialize(){
        codePattern = Pattern.compile("^([M0]{3})([0-9]{2})$");
        descriptionPattern = Pattern.compile("^([\\w\\s\\D][^0-9]{1,})$");
        expirationDatePattern = Pattern.compile("^([0-3]{4}[-][0-1]{1}[0-9]{1}[-][0-3]{1}[0-9]{1})$");
        qtyPattern = Pattern.compile("^([0-9]{1,4})$");
        pricePattern = Pattern.compile("^([0-9]{1,}[.][0-9]{2})$");

        this.medicationService = ServiceFactory.getInstance().getService(ServiceTypes.MEDICATION);
    }

    public void txtMCodeOnAction(ActionEvent actionEvent) {
        if (txtMCode.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING,"Please enter ID.").show();
        }

        String mCode = txtMCode.getText();

        try {
            Medication medication = medicationService.searchMedication(mCode);
            if (medication == null) {
                new Alert(Alert.AlertType.WARNING, "Medication Not Found!").show();
            } else {
                txtDescription.setText(medication.getDescription());
                txtExpirationDate.setText(medication.getExpirationDate()+"");
                txtQty.setText(medication.getQty()+"");
                txtPrice.setText(medication.getPrice()+"");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            Medication medication = MedicationModel.searchMedication(mCode);
//            if (medication == null) {
//                new Alert(Alert.AlertType.WARNING, "Medication Not Found!").show();
//            } else {
//                txtDescription.setText(medication.getDescription());
//                txtExpirationDate.setText(medication.getExpirationDate()+"");
//                txtQty.setText(medication.getQty()+"");
//                txtPrice.setText(medication.getPrice()+"");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void txtDescriptionOnAction(ActionEvent actionEvent) {
        boolean isDescriptionMatched = descriptionPattern.matcher(txtDescription.getText()).matches();
        if (!isDescriptionMatched) {
            txtDescription.setFocusColor(Paint.valueOf("Red"));
            txtDescription.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Description.").show();
        } else {
            txtExpirationDate.requestFocus();
        }
    }

    public void txtExpirationDateOnAction(ActionEvent actionEvent) {
        boolean isExpirationDateMatched = expirationDatePattern.matcher(txtExpirationDate.getText()).matches();
        if (!isExpirationDateMatched) {
            txtExpirationDate.setFocusColor(Paint.valueOf("Red"));
            txtExpirationDate.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Date.").show();
        } else {
            txtQty.requestFocus();
        }
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
        boolean isQtyMatched = qtyPattern.matcher(txtQty.getText()).matches();
        if (!isQtyMatched) {
            txtQty.setFocusColor(Paint.valueOf("Red"));
            txtQty.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Qty.").show();
        } else {
            txtPrice.requestFocus();
        }
    }

    public void txtPriceOnAction(ActionEvent actionEvent) {
        boolean isPriceMatched = pricePattern.matcher(txtPrice.getText()).matches();
        if (!isPriceMatched) {
            txtPrice.setFocusColor(Paint.valueOf("Red"));
            txtPrice.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Price.").show();
        } else {
            btnUpdateOnAction(actionEvent);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        if (txtMCode.getText().equals("") || txtDescription.getText().equals("") ||
                txtExpirationDate.getText().equals("") || txtQty.getText().equals("") ||
                txtPrice.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String mCode = txtMCode.getText();
        String description = txtDescription.getText();
        Date ex_Date = Date.valueOf(txtExpirationDate.getText());
        int qty = Integer.parseInt(txtQty.getText());
        Double price = Double.parseDouble(txtPrice.getText());

        Medication medication = new Medication(mCode,description,ex_Date,qty,price);

        try {
            boolean isUpdated = medicationService.updateMedication(medication);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successful").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            boolean isAdded = MedicationModel.updateMedication(medication);
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
        txtMCode.clear();
        txtDescription.clear();
        txtExpirationDate.clear();
        txtQty.clear();
        txtPrice.clear();
    }
}

//  Done
//  Regex