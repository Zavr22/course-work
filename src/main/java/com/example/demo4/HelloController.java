package com.example.demo4;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.example.demo4.metods.*;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  Button autorithationButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        autorithationButton.setOnAction(event -> {
            String login=login_field.getText().trim();
            String password=password_field.getText().trim();
            User user =new User();
            user.setLogin(login);
            user.setPassword(password);

            if((!login.equals(""))&&(!password.equals(""))) {
                if ((login.equals("admin")) && (password.equals( "admin")))
                {
                    autorithationButton.getScene().getWindow().hide();
                    oppenNewScene("/com/example/demo4/admin.fxml");
                }
                else
               if (checkUser(user))
                   oppenNewScene("/com/example/demo4/okScene.fxml");
            }
            else {
               oppenNewScene("/com/example/demo4/error1.fxml");
            }
       });
        signUpButton.setOnAction(event -> {
          signUpButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/registration.fxml");
        });
    }
}