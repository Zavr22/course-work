package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo4.metods.oppenNewScene;

public class bidCreateController {

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
    private TextField firstKevField;

    @FXML
    private TextField firstTeamField;

    @FXML
    private TextField secondKevField;

    @FXML
    private TextField secondTeamField;

    @FXML
    private TextField spotField;

    @FXML
    void initialize() {

            buttonBack.setOnAction(event -> {
                buttonBack.getScene().getWindow().hide();
                oppenNewScene("/com/example/demo4/admin.fxml");
            });


            createButton.setOnAction(event -> {
                String team1=firstTeamField.getText();
                String team2=secondTeamField.getText();
                double kev1= Double.parseDouble(firstKevField.getText());
                double kev2= Double.parseDouble(secondKevField.getText());
                Bet bet=new Bet(team1,team2,kev1,kev2);
                DatabaseHandler db=new DatabaseHandler();
                /*if (checkBoxAgreemet.isSelected() && !login_field.getText().equals("")
                        && !password_field.getText().equals("")&& !name_field.getText().equals("")
                        && !surname_field.getText().equals("")) {
                    db.createBet(bet);
                    signnUpButton.getScene().getWindow().hide();
                    oppenNewScene("/com/example/demo4/Hello.fxml");
                }
                else
                    oppenNewScene("/com/example/demo4/error2.fxml");
            });*/
        });



    }
}


