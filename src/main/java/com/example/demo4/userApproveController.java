package com.example.demo4;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.demo4.metods.oppenNewScene;

public class userApproveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button approveButton;

    @FXML
    private URL location;

    @FXML
    private Button infoButton;

    @FXML
    private TextField errorText;

    @FXML
    private TableView<User> Table;

    @FXML
    private TableColumn<User, Integer> approvedfield;

    @FXML
    private Button buttonBack;

    @FXML
    private TableColumn<User, String> loginfield;

    @FXML
    private TableColumn<User, String> namefield;

    @FXML
    private TableColumn<User, String> surnamefield;

    ObservableList<User> userlist= FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        updateTable();

        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/admin.fxml");
        });
        approveButton.setOnAction((event -> {
            User user = Table.getSelectionModel().getSelectedItem();
            if(user==null)
            {
                errorText.setVisible(true);
            }
            else
            {
                errorText.setVisible(false);
                DatabaseHandler dbha=new DatabaseHandler();
                dbha.updateApprove(user);
            }
            try {
                updateTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));


        }
        public void updateTable() throws SQLException {
        userlist.clear();
            DatabaseHandler dbh=new DatabaseHandler();
            ResultSet rs=dbh.getUsers();
            while (rs.next()) {
                String login=rs.getString("login");
                String name=rs.getString("name");
                String surname=rs.getString("surname");
                int isApprove=rs.getInt("isApprove");
                userlist.add(new User(isApprove,name,surname,login));
            }
            loginfield.setCellValueFactory(new PropertyValueFactory<>("login"));
            namefield.setCellValueFactory(new PropertyValueFactory<>("name"));
            surnamefield.setCellValueFactory(new PropertyValueFactory<>("surName"));
            approvedfield.setCellValueFactory(new PropertyValueFactory<>("isApprove"));
            Table.setItems(userlist);

        }

    }


