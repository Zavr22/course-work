package com.example.demo4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    }

}
