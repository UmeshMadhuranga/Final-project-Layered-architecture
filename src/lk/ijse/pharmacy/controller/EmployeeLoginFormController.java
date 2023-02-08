package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeLoginFormController {
    public AnchorPane pane;
    public AnchorPane pane1;

    public void initialize() throws IOException {
        Navigation.navigate(Routes.PLACEORDER, pane1);
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnBillingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PLACEORDER, pane1);
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, pane1);
    }

    public void btnMedicationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MEDICATION,pane1);
    }

    public void btnPaymentOnAction(ActionEvent actionEvent) {
    }

    public void btnOrdersOnAction(ActionEvent actionEvent) {
    }
}
