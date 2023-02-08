package lk.ijse.pharmacy.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static lk.ijse.pharmacy.util.Routes.LOGIN;
import static lk.ijse.pharmacy.util.Routes.SIGNIN;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes routes, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();

        switch (routes) {
            case LOGIN:
                initUI("LoginForm.fxml");
                break;

            case SIGNIN:
                initUI("SignInForm.fxml");
                break;

            case ADMINLOGIN:
                initUI("AdminLoginForm.fxml");
                break;

            case EMPLOYEE:
                initUI("EmployeeForm.fxml");
                break;

            case SUPPLIER:
                initUI("SupplierForm.fxml");
                break;

            case CUSTOMER:
                initUI("CustomerForm.fxml");
                break;

            case EMPLOYEELOGIN:
                initUI("EmployeeLoginForm.fxml");
                break;

            case ADDEMPLOYEE:
                initUI("AddEmployeeForm.fxml");
                break;

            case UPDATEEMPLOYEE:
                initUI("UpdateEmployeeForm.fxml");
                break;

            case DELETEEMPLOYEE:
                initUI("DeleteEmployeeForm.fxml");
                break;

            case ADDSUPPLIER:
                initUI("AddSupplierForm.fxml");
                break;

            case UPDATESUPPLIER:
                initUI("UpdateSupplierForm.fxml");
                break;

            case DELETESUPPLIER:
                initUI("DeleteSupplierForm.fxml");
                break;

            case ADDCUSTOMER:
                initUI("AddCustomerForm.fxml");
                break;

            case UPDATECUSTOMER:
                initUI("UpdateCustomerForm.fxml");
                break;

            case DELETECUSTOMER:
                initUI("DeleteCustomerForm.fxml");
                break;

            case PLACEORDER:
                initUI("PlaceOrderForm.fxml");
                break;

            case MEDICATION:
                initUI("MedicationForm.fxml");
                break;

            case ADDMEDICATION:
                initUI("AddMedicationForm.fxml");
                break;

            case UPDATEMEDICATION:
                initUI("UpdateMedicationForm.fxml");
                break;

            case DELETEMEDICATION:
                initUI("DeleteMedicationForm.fxml");
                break;

            case ADMIN:
                initUI("AdminForm.fxml");
                break;

            case ADDADMIN:
                initUI("AddAdminForm.fxml");
                break;

            case UPDATEADMIN:
                initUI("UpdateAdminForm.fxml");
                break;

            case DELETEADMIN:
                initUI("DeleteAdminForm.fxml");
                break;
        }
    }

    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader
                .load(Navigation.class.getResource("/lk/ijse/pharmacy/view/"+location))
        );
    }
}
