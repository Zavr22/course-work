package com.example.demo4;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.demo4.metods.*;

public class registrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private CheckBox checkBoxAgreemet;

    @FXML
    private TextField login_field;

    @FXML
    private TextField name_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signnUpButton;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/Hello.fxml");
        });


        signnUpButton.setOnAction(event -> {
            String name=name_field.getText();
            String surName=surname_field.getText();
            String login=login_field.getText();
            String passwor=password_field.getText();
            User user=new User(name, surName,login,passwor);
            DatabaseHandler db=new DatabaseHandler();
            if(checkUserLogin(user))
                oppenNewScene("/com/example/demo4/error3.fxml");
            else
            if (checkBoxAgreemet.isSelected() && !login_field.getText().equals("")
                    && !password_field.getText().equals("")&& !name_field.getText().equals("")
                    && !surname_field.getText().equals(""))
            db.signUp(user);
            else
                oppenNewScene("/com/example/demo4/error2.fxml");
        });
    }


}