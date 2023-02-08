package lk.ijse.pharmacy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.model.SupplierModel;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;
import lk.ijse.pharmacy.to.Supplier;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierFormController {
    public TableView tblSupplier;

    public TableColumn colSId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colPhone;

    public AnchorPane pane1;
    public ComboBox cmbOption;

    public ObservableList<Supplier> observableList = FXCollections.observableArrayList();

    public void initialize(){
        colSId.setCellValueFactory(new PropertyValueFactory<Supplier,String>("sId"));
        colName.setCellValueFactory(new PropertyValueFactory<Supplier,String>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Supplier,String>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Supplier,String>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("phone"));

        LoadOptions();
        LoadSupplier();
    }

    private void LoadSupplier() {
        try {
            ArrayList<Supplier> list = SupplierModel.getAllSupplier();

            for(Supplier supplier : list){
                observableList.add(supplier);
            }
            tblSupplier.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void LoadOptions() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Add Supplier","Update Supplier","Delete Supplier");
        cmbOption.getItems().setAll(obList);
    }

    public void btnOkOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Add Supplier")) {
            Navigation.navigate(Routes.ADDSUPPLIER, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Update Supplier")) {
            Navigation.navigate(Routes.UPDATESUPPLIER, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Delete Supplier")) {
            Navigation.navigate(Routes.DELETESUPPLIER, pane1);
        }
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        observableList.clear();
        LoadSupplier();
    }
}

//  Done