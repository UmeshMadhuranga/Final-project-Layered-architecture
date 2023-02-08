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
import lk.ijse.pharmacy.model.AdminModel;
import lk.ijse.pharmacy.model.LoginModel;
import lk.ijse.pharmacy.to.Admin;
import lk.ijse.pharmacy.util.Navigation;
import lk.ijse.pharmacy.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;

public class LoginFormController {
    public JFXTextField txtEmail;
    public AnchorPane pane;
    public AnchorPane pane1;
    public JFXPasswordField txtPassword;

    public static Stage stage;

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
        Admin admin = new Admin(email,password);
        try {
            boolean b = LoginModel.searchEmail(admin);
            if (b) {
                if (LoginModel.resultSet.getString(5).equals("Admin")) {
                    Navigation.navigate(Routes.ADMINLOGIN,pane);
                } else {
                    Navigation.navigate(Routes.EMPLOYEELOGIN,pane);
                }
            } else {
                new Alert(Alert.AlertType.WARNING,"Please enter correct password and email.!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
