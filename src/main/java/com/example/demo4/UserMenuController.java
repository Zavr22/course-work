package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

import static com.example.demo4.metods.oppenNewScene;

public class UserMenuController {

    @FXML
    private Button bidButton;

    @FXML
    private Button bidSotoryButton;

    @FXML
    private Button buttonBack;

    @FXML
    private Button charatyButton;

    @FXML
    private Button moneyButton;
    @FXML
    void initialize() throws SQLException {
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/Hello.fxml");
        });
        bidButton.setOnAction(event -> {
            bidButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/bidMenuUser.fxml");
        });
        bidSotoryButton.setOnAction(event -> {
            bidSotoryButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/bidStoryUser.fxml");

        });
        charatyButton.setOnAction(event -> {
            charatyButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/Charity.fxml");

        });
        moneyButton.setOnAction(event -> {
            moneyButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/Money.fxml");

        });

    }


}
