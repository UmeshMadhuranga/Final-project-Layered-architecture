package lk.ijse.pharmacy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pharmacy.dto.EmployeeDTO;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.EmployeeService;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NavigableMap;

public class EmployeeFormController {
    public TableView tblEmployee;

    public TableColumn colEmId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colPhone;

    public ComboBox cmbOption;
    public AnchorPane pane1;

    private EmployeeService employeeService;

    public ObservableList<EmployeeDTO> observableList = FXCollections.observableArrayList();

    public void initialize(){
        LoadOptions();

        colEmId.setCellValueFactory(new PropertyValueFactory<Employee,String>("emID"));
        colName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Employee,String>("phone"));

        LoadEmployee();
        this.employeeService = ServiceFactory.getInstance().getService(ServiceTypes.EMPLOYEE);
    }

    private void LoadOptions() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Add Employee","Update Employee","Delete Employee");
        cmbOption.getItems().setAll(obList);
    }

    public void btnOkOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Add Employee")) {
            Navigation.navigate(Routes.ADDEMPLOYEE, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Update Employee")) {
            Navigation.navigate(Routes.UPDATEEMPLOYEE, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Delete Employee")) {
            Navigation.navigate(Routes.DELETEEMPLOYEE, pane1);
        }
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        observableList.clear();
        LoadEmployee();
    }

    private void LoadEmployee() {
        try {
            ArrayList<EmployeeDTO> allEmployee = employeeService.getAllEmployee();
            for(EmployeeDTO employee : allEmployee){
                observableList.add(employee);
            }
            tblEmployee.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            ArrayList<Employee> list = EmployeeModel.getAllEmployees();
//
//            for(Employee employee : list){
//                observableList.add(employee);
//            }
//            tblEmployee.setItems(observableList);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
