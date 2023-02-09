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
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.MedicationService;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicationFormController {
    public AnchorPane pane1;
    public ComboBox cmbOption;

    public TableView tblMedication;

    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colExpirationDate;
    public TableColumn colQty;
    public TableColumn colPrice;

    public ObservableList<Medication> observableList = FXCollections.observableArrayList();

    private MedicationService medicationService;

    public void initialize(){
        colCode.setCellValueFactory(new PropertyValueFactory<Employee,String>("mCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Employee,String>("description"));
        colExpirationDate.setCellValueFactory(new PropertyValueFactory<Employee,String>("expirationDate"));
        colQty.setCellValueFactory(new PropertyValueFactory<Employee,String>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Employee,String>("price"));

        LoadOptions();
        LoadMedication();
        this.medicationService = ServiceFactory.getInstance().getService(ServiceTypes.MEDICATION);
    }

    private void LoadMedication() {
        try {
            ArrayList<Medication> list = medicationService.getAllMedication();
            for(Medication medication : list){
                observableList.add(medication);
            }
            tblMedication.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            ArrayList<Medication> list = MedicationModel.getAllMedication();
//
//            for(Medication medication : list){
//                observableList.add(medication);
//            }
//            tblMedication.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void LoadOptions() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Add Medication","Update Medication","Delete Medication");
        cmbOption.getItems().setAll(obList);
    }

    public void btnOkOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Add Medication")) {
            Navigation.navigate(Routes.ADDMEDICATION, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Update Medication")) {
            Navigation.navigate(Routes.UPDATEMEDICATION, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Delete Medication")) {
            Navigation.navigate(Routes.DELETEMEDICATION, pane1);
        }
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        observableList.clear();
        LoadMedication();
    }
}

//  Done