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

import static com.example.demo4.metods.oppenNewScene;

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
                oppenNewScene("/com/example/demo4/adminMenu.fxml");
            }
            if((!login.equals(""))&&(!password.equals("")))
                loginUser(login,password);
            else {
               oppenNewScene("/com/example/demo4/error1.fxml");
            }
        }));
        signUpButton.setOnAction(event -> {
          signUpButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/registration.fxml");
        });
    }

    public static void loginUser(String login, String password) {
    }
}