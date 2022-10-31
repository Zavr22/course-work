package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button autorithationButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        autorithationButton.setOnAction((event -> {
            String login=login_field.getText().trim();
            String password=password_field.getText().trim();
            if((login.equals("admin")) && (password.equals("admin")) )
            {
                autorithationButton.getScene().getWindow().hide();
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("/com/example/demo4/adminMenu.fxml"));
                try {
                    loader1.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root1 = loader1.getRoot();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            }
            if((!login.equals(""))&&(!password.equals("")))
                loginUser(login,password);
            else {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/demo4/error1.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root=loader.getRoot();
                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
        }));
        signUpButton.setOnAction(event -> {
          signUpButton.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/demo4/registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    public static void loginUser(String login, String password) {
    }
}