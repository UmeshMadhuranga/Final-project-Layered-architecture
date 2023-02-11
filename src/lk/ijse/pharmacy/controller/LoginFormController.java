package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.pharmacy.dto.AdminDTO;
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.LoginModel;
import lk.ijse.pharmacy.service.ServiceFactory;
import lk.ijse.pharmacy.service.ServiceTypes;
import lk.ijse.pharmacy.service.custom.AdminService;
import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginFormController {
    public JFXTextField txtEmail;
    public AnchorPane pane;
    public AnchorPane pane1;
    public JFXPasswordField txtPassword;

    public static Stage stage;

    private AdminService adminService;

    public void initialize(){
        this.adminService = ServiceFactory.getInstance().getService(ServiceTypes.ADMIN);
    }

    public void emailOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if (txtEmail.getText().equals("") || txtPassword.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Email And Password.!").show();
            return;
        }

        AdminDTO adminDTO = new AdminDTO(email,password);

        try {
            ResultSet resultSet = adminService.searchAdminEmail(adminDTO);
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(email) &&
                        resultSet.getString(6).equals(password)) {
                    System.out.println(resultSet.getString(5));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING,"Please enter correct password and email.!").show();
        }
//        try {
//            String role = adminService.searchAdminEmail(adminDTO);
//            System.out.println(role);
//
//            if (isExists) {
//                if (LoginModel.resultSet.getString(5).equals("Admin")) {
//                    Navigation.navigate(Routes.ADMINLOGIN,pane);
//                } else {
//                    Navigation.navigate(Routes.EMPLOYEELOGIN,pane);
//                }
//            } else {
//                new Alert(Alert.AlertType.WARNING,"Please enter correct password and email.!").show();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            new Alert(Alert.AlertType.WARNING, "Duplicate primary key!").show();
//        }

//        try {
//            boolean b = LoginModel.searchEmail(admin);
//            if (b) {
//                if (LoginModel.resultSet.getString(5).equals("Admin")) {
//                    Navigation.navigate(Routes.ADMINLOGIN,pane);
//                } else {
//                    Navigation.navigate(Routes.EMPLOYEELOGIN,pane);
//                }
//            } else {
//                new Alert(Alert.AlertType.WARNING,"Please enter correct password and email.!").show();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch ( ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {
        stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("../view/SignInForm.fxml"))));
        stage.setTitle("Add new user");
        stage.show();
    }

    public void btnEmployeeLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEELOGIN, pane);
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        btnLoginOnAction(actionEvent);
    }
}
