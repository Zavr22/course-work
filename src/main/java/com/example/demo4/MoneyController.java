package com.example.demo4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static com.example.demo4.HelloController.selectedUser;
import static com.example.demo4.metods.oppenNewScene;

public class MoneyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button createButton;

    @FXML
    private TextField errorText;

    @FXML
    private TextField spotField;

    @FXML
    void initialize() {
        errorText.setVisible(false);
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/UserMenu.fxml");
        });
        createButton.setOnAction(event -> {
            double money= Double.parseDouble(spotField.getText());
            if(spotField.getText().equals("") ) {
                errorText.setVisible(true);
                errorText.setText("ВЫ не выбрали сумму");
            }
            else
            {
                DatabaseHandler dbh=new DatabaseHandler();
                dbh.updateMoneyIncome(selectedUser,money);
                selectedUser.setMoney(selectedUser.getMoney()+money);
                oppenNewScene("/com/example/demo4/UserMenu.fxml");
            }
        });

    }

}
