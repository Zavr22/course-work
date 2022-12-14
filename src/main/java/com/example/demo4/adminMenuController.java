package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo4.metods.oppenNewScene;

public class adminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bidButton;

    @FXML
    private Button bidWinnerButton;

    @FXML
    private Button buttonBack;

    @FXML
    private Button storyButton;

    @FXML
    private Button userButton;

    @FXML
    void initialize() {
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/Hello.fxml");
        });
        userButton.setOnAction(event->{
            userButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/userApprove.fxml");
        });
        bidButton.setOnAction(event->{
            bidButton.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/bidCreate.fxml");
        });
    }

}
