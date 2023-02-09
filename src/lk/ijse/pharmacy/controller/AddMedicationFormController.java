package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.MedicationService;
import lk.ijse.pharmacy.to.Medication;

import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddMedicationFormController {
    public JFXTextField txtCode;
    public JFXTextField txtDescription;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;
    public JFXDatePicker txtExpirationDate;

    private Pattern codePattern;
    private Pattern descriptionPattern;
    private Pattern expirationDatePattern;
    private Pattern qtyPattern;
    private Pattern pricePattern;

    private MedicationService medicationService;

    public void initialize(){
        codePattern = Pattern.compile("^([M0]{3})([0-9]{2})$");
        descriptionPattern = Pattern.compile("^([A-Za-z0-9\\s\\W]{1,})$");
        expirationDatePattern = Pattern.compile("^([0-3]{4}[-][0-1]{1}[0-9]{1}[-][0-3]{1}[0-9]{1})$");
        qtyPattern = Pattern.compile("^([0-9]{1,4})$");
        pricePattern = Pattern.compile("^([0-9]{1,}[.][0-9]{2})$");

        medicationService = ServiceFactory.getInstance().getService(ServiceTypes.MEDICATION);
    }

    public void txtCodeOnAction(ActionEvent actionEvent) {
        boolean isCodeMatched = codePattern.matcher(txtCode.getText()).matches();
        if (!isCodeMatched) {
            txtCode.setFocusColor(Paint.valueOf("Red"));
            txtCode.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Code.").show();
        } else {
            txtDescription.requestFocus();
        }
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
            btnAddMedication(actionEvent);
        }
    }

    public void btnAddMedication(ActionEvent actionEvent) {
        if (!(txtPrice.getText().matches("^([0-9]{1,}[.][0-9]{2})$"))) {
            txtPrice.setFocusColor(Paint.valueOf("Red"));
            txtPrice.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Price.").show();
            return;
        } else if (txtCode.getText().equals("") || txtDescription.getText().equals("") ||
                txtExpirationDate.getValue().equals("") || txtQty.getText().equals("") ||
                txtPrice.getText().equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please Enter The Data.!").show();
            return;
        }
        String code = txtCode.getText();
        String description = txtDescription.getText();
        Date ex_Date = Date.valueOf(txtExpirationDate.getValue());
        int qty = Integer.parseInt(txtQty.getText());
        Double price = Double.parseDouble(txtPrice.getText());

        Medication medication = new Medication(code,description,ex_Date,qty,price);
        try {
            if (medicationService.addMedication(medication)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Medication Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
            }
            clearText();
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
        }

//        try {
//            boolean isAdded = MedicationModel.addNewMedication(code,description,ex_Date,qty,price);
//            if (isAdded) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Medication Added!").show();
//            } else {
//                new Alert(Alert.AlertType.WARNING, "Something Wrong!").show();
//            }
//            clearText();
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void btnCancel(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtCode.clear();
        txtDescription.clear();
        txtQty.clear();
        txtPrice.clear();
    }

    public void txtDescriptionOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtCode.getText().matches("^([M0]{3})([0-9]{2})$"))) {
            txtCode.setFocusColor(Paint.valueOf("Red"));
            txtCode.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Code.").show();
        } else {
            txtDescription.requestFocus();
        }
    }

    public void txtQtyOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtDescription.getText().matches("^([A-Za-z0-9\\s\\W]{1,})$"))) {
            txtDescription.setFocusColor(Paint.valueOf("Red"));
            txtDescription.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Description.").show();
        } else {
            txtQty.requestFocus();
        }
    }

    public void txtPriceOnMouseClicked(MouseEvent mouseEvent) {
        if (!(txtQty.getText().matches("^([0-9]{1,4})$"))) {
            txtQty.setFocusColor(Paint.valueOf("Red"));
            txtQty.requestFocus();
            new Alert(Alert.AlertType.ERROR,"invalid Qty.").show();
        } else {
            txtPrice.requestFocus();
        }
    }
}

//Done
//Regex