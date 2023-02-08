package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;

public class AdminLoginFormController {
    public AnchorPane pane;
    public AnchorPane pane1;

    public void initialize() throws IOException {
        Navigation.navigate(Routes.PLACEORDER, pane1);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnManageEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, pane1);
    }

    public void btnManageSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER, pane1);
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, pane1);
    }

    public void btnManageOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PLACEORDER, pane1);
    }

    public void btnIncomeReportOnAction(ActionEvent actionEvent) {
    }

    public void btnMedicationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MEDICATION, pane1);
    }

    public void btnAdminOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN, pane1);
    }
}
