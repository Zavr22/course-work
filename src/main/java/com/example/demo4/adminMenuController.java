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
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(getClass().getResource("/com/example/demo4/Hello.fxml"));
            try {
                loader1.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root1 = loader1.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        });
    }

}
