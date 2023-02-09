package lk.ijse.pharmacy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.MedicationModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.to.Medication;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminFormController {
    public TableView tblAdmin;

    public TableColumn colUserId;
    public TableColumn colUserName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colRole;

    public AnchorPane pane1;
    public ComboBox cmbOption;

    public ObservableList<Admin> observableList = FXCollections.observableArrayList();
    private AdminService adminService;

    public void initialize(){
        colUserId.setCellValueFactory(new PropertyValueFactory<Admin,String>("uId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<Admin,String>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Admin,String>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Admin,String>("address"));
        colRole.setCellValueFactory(new PropertyValueFactory<Admin,String>("role"));

        LoadOptions();
        LoadAdmin();
        this.adminService = ServiceFactory.getInstance().getService(ServiceTypes.ADMIN);
    }

    private void LoadAdmin() {
        try {
            ArrayList<Admin> allAdmins = adminService.getAllAdmins();
            for(Admin admin : allAdmins){
                observableList.add(admin);
            }
            tblAdmin.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            ArrayList<Admin> list = AdminModel.getAllAdmin();
//
//            for(Admin admin : list){
//                observableList.add(admin);
//            }
//            tblAdmin.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void LoadOptions() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Add Admin","Update Admin","Delete Admin");
        cmbOption.getItems().setAll(obList);
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        observableList.clear();
        LoadAdmin();
    }

    public void btnOkOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Add Admin")) {
            Navigation.navigate(Routes.ADDADMIN, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Update Admin")) {
            Navigation.navigate(Routes.UPDATEADMIN, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Delete Admin")) {
            Navigation.navigate(Routes.DELETEADMIN, pane1);
        }
    }
}
