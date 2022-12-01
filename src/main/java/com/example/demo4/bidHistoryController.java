package com.example.demo4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
public class bidHistoryController {



        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<?, ?> bedColumn;

        @FXML
        private Button buttonBack;

        @FXML
        private TextField errorText;

        @FXML
        private TableColumn<?, ?> kevColumn;

        @FXML
        private TableColumn<?, ?> resColumn;

        @FXML
        private TableColumn<?, ?> sportColumn;

        @FXML
        private TableColumn<?, ?> teamColumn;

        @FXML
        void initialize() {
            assert bedColumn != null : "fx:id=\"bedColumn\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert kevColumn != null : "fx:id=\"kevColumn\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert resColumn != null : "fx:id=\"resColumn\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert sportColumn != null : "fx:id=\"sportColumn\" was not injected: check your FXML file 'userApprove.fxml'.";
            assert teamColumn != null : "fx:id=\"teamColumn\" was not injected: check your FXML file 'userApprove.fxml'.";

        }

    }


