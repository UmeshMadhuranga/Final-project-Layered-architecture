package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.model.OrderModel;
import lk.ijse.pharmacy.to.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PlaceOrderFormController {
    public Label lblBillingID;
    public Label lblOrderDate;

    public JFXComboBox cmbCustomerID;
    public ComboBox cmbMedicationCode;

    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQty;
    public JFXTextField txtQty;
    public Label lblCustomerName;

    public TableView tblCart;

    public TableColumn colMCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colAction;

    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();

    public void initialize() {
        loadNextOrderId();
        loadOrderDate();
        loadCustomerIds();
        LoadMedicationCodes();
        setCellValueFactory();
    }

    private void LoadMedicationCodes() {
        ObservableList<String> observableList = FXCollections.observableArrayList();

        try {
            ArrayList<String> codeList = CustomerModel.loadMedicationCode();
            for (String code : codeList) {
                observableList.add(code);
            }
            cmbMedicationCode.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerIds() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {
            ArrayList<String> idList = CustomerModel.loadCustomerIds();
            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerID.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadOrderDate() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }

    private void loadNextOrderId() {
        try {
            String orderId = OrderModel.generateNextOrderId();
            lblBillingID.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("/lk/ijse/pharmacy/view/AddCustomerForm.fxml")
        )));
        stage.show();
    }

    public void cmbMedicationCodeOnAction(ActionEvent actionEvent) {
        String code =String.valueOf(cmbMedicationCode.getValue());

        try {
            Medication medication = MedicationModel.searchMedication(code);
            fillTheFields(medication);
            txtQty.requestFocus();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fillTheFields(Medication medication) {
        lblDescription.setText(medication.getDescription());
        lblUnitPrice.setText(medication.getPrice()+"");
        lblQty.setText(medication.getQty()+"");
    }

    public void cmbCustomerIDOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbCustomerID.getValue());

        try {
            Customer customer = CustomerModel.searchCustomer(id);
            fillCustomerName(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fillCustomerName(Customer customer) {
        lblCustomerName.setText(customer.getName());
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbMedicationCode.getValue());
        int qty = Integer.parseInt(txtQty.getText());
        String description = lblDescription.getText();
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = unitPrice * qty;
        Button btnDelete = new Button("Delete");

        txtQty.clear();

        if (!obList.isEmpty()) {
            for (int i=0; i<tblCart.getItems().size(); i++) {
                if (colMCode.getCellData(i).equals(code)) {
                    qty += (int) colQty.getCellData(i);

                    total = unitPrice * qty;
                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblCart.refresh();
                    return;
                }
            }
        }

        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                PlaceOrderTM tm = (PlaceOrderTM) tblCart.getSelectionModel().getSelectedItem();
                tblCart.getItems().removeAll(tm);
            }});
        obList.add(new PlaceOrderTM(code,description,qty,unitPrice,total,btnDelete));
        tblCart.setItems(obList);
    }

    private void setCellValueFactory() {
        colMCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("button"));
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) {
        String billingID = lblBillingID.getText();
        String customerId = String.valueOf(cmbCustomerID.getValue());

        ArrayList<CartDetails> list = new ArrayList();

        for (int i = 0 ; i < tblCart.getItems().size(); i++){
            PlaceOrderTM tm = obList.get(i);
            list.add(new CartDetails(tm.getCode(),String.valueOf(tm.getQty())));
        }
        PlaceOrder placeOrder = new PlaceOrder(billingID,customerId,list);

        try {
            boolean b = OrderModel.addOrder(placeOrder);

            if (b){
                new Alert(Alert.AlertType.INFORMATION,"Order Confirm").show();
                loadNextOrderId();
            }else {
                new Alert(Alert.AlertType.WARNING,"Something Wrong.").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblCart.setItems(null);
    }
}
