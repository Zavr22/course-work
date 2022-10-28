package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        assert autorithationButton != null : "fx:id=\"autorithationButton\" was not injected: check your FXML file 'Untitled'.";
        assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'Untitled'.";
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'Untitled'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'Untitled'.";

    }
}