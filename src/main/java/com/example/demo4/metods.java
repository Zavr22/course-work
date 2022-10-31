package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class metods {
    public static void oppenNewScene(String window)
    {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(metods.class.getResource(window));
        try {
            loader1.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root1 = loader1.getRoot();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }
}
