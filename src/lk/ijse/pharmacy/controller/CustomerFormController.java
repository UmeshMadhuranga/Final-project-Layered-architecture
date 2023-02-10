package lk.ijse.pharmacy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.dto.CustomerDTO;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.CustomerService;
import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {
    public TableView tblCustomer;

    public TableColumn colCId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colPhone;

    public AnchorPane pane1;
    public ComboBox cmbOption;

    public ObservableList<CustomerDTO> observableList = FXCollections.observableArrayList();

    private CustomerService customerService;

    public void initialize(){
        colCId.setCellValueFactory(new PropertyValueFactory<Customer,String>("cId"));
        colName.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("phone"));

        LoadOptions();
        LoadCustomer();
        this.customerService = ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);
    }

    private void LoadCustomer() {
        try {
            //ArrayList<Customer> list = CustomerModel.getAllCustomer();
            ArrayList<CustomerDTO> list = customerService.getAllCustomer();
            for(CustomerDTO customer : list){
                observableList.add(customer);
            }
            tblCustomer.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void LoadOptions() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("Add Customer","Update Customer","Delete Customer");
        cmbOption.getItems().setAll(obList);
    }

    public void btnOkOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Add Customer")) {
            Navigation.navigate(Routes.ADDCUSTOMER, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Update Customer")) {
            Navigation.navigate(Routes.UPDATECUSTOMER, pane1);
        } else if (cmbOption.getSelectionModel().getSelectedItem().toString().equals("Delete Customer")) {
            Navigation.navigate(Routes.DELETECUSTOMER, pane1);
        }
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        observableList.clear();
        LoadCustomer();
    }
}
