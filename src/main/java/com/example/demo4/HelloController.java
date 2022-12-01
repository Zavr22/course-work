package com.example.demo4;

import javafx.fxml.FXML;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
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
                else {

                    try {
                        if (checkUser(user) && checkApprove(user) )
                            oppenNewScene("/com/example/demo4/UserMenu.fxml");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        if (!checkUser(user) )
                        {
                            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                           alert.setContentText("Неправильный логин или пароль");
                            alert.showAndWait();
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                       if (!checkApprove(user))
                     {
                         Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                          alert.setContentText("Вас не подтвердил админ");
                          alert.showAndWait();
                      }
                  } catch (SQLException e) {
                       throw new RuntimeException(e);
                    }

                }
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