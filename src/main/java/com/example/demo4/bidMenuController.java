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

public class bidMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Bet> Table;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField error;

    @FXML
    private Button infoButton;

    @FXML
    private TableColumn<Bet, Double> kev1Field;
    @FXML
    private TableColumn<Bet, Integer> idcolumn;


    @FXML
    private Button makeButton;

    @FXML
    private TableColumn<Bet, String> sportField;

    @FXML
    private TableColumn<Bet, String> team1Field;

    @FXML
    private TableColumn<Bet, String> team2Field;

    @FXML
    private TableColumn<Bet, Double> team2Kev;
    ObservableList<Bet> betList= FXCollections.observableArrayList();
    static Bet selectedBet;

    @FXML
    void initialize() throws SQLException {
        updateTable();
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/UserMenu.fxml");
        });
        makeButton.setOnAction((event -> {
            Bet bet = Table.getSelectionModel().getSelectedItem();
            if(bet==null)
            {
                error.setVisible(true);
            }
            else
            {
                error.setVisible(false);
                makeButton.getScene().getWindow().hide();
                selectedBet=bet;
                oppenNewScene("/com/example/demo4/makeBid.fxml");

            }
            try {
                updateTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));


    }
    public void updateTable() throws SQLException {
        betList.clear();
        DatabaseHandler dbh=new DatabaseHandler();
        ResultSet rs=dbh.getBets();
        while (rs.next()) {
            String team1=rs.getString("team_1");
            String team2=rs.getString("team_2");
            String sport=rs.getString("sport");
            double kev1=rs.getDouble("kev_1");
            double kev2=rs.getDouble("kev_2");
            int id=rs.getInt("id");
            betList.add(new Bet(team1,team2,kev1,kev2,sport,id));
        }
        team1Field.setCellValueFactory(new PropertyValueFactory<>("team1"));
        team2Field.setCellValueFactory(new PropertyValueFactory<>("team2"));
        kev1Field.setCellValueFactory(new PropertyValueFactory<>("kev1"));
        team2Kev.setCellValueFactory(new PropertyValueFactory<>("kev2"));
        sportField.setCellValueFactory(new PropertyValueFactory<>("sport"));
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("betId"));
        Table.setItems(betList);

    }

}
