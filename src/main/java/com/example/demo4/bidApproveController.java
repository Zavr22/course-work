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

public class bidApproveController {

    @FXML
    private ResourceBundle resources;
    static int winnigteam;

    @FXML
    private URL location;

    @FXML
    private TableView<Event> Table;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField error;

    @FXML
    private Button confrimButton;
    @FXML
    private Button confrimButton1;


    @FXML
    private TableColumn<Event, Double> kevField;

    @FXML
    private TableColumn<Event, String> secondTeamfield;

    @FXML
    private TableColumn<Event, String> sportField;

    @FXML
    private TableColumn<Event, Double> sumField;

    @FXML
    private TableColumn<Event, String> teamField;
    @FXML
    private TableColumn<Event, Integer> userId;
    @FXML
    private TableColumn<Event, Integer> betId;
    @FXML
    private TableColumn<Event, Integer> winTeam;

    ObservableList<Event> eventList= FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        updateTable();
        confrimButton.setOnAction(event -> {
            Event event1=Table.getSelectionModel().getSelectedItem();
            if(event1==null)
            {
                error.setVisible(true);
            }
            else {
            DatabaseHandler dbh=new DatabaseHandler();
            User user = new User();
                try {
                    user=dbh.findUserById(event1.getUserId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                dbh.superUpdateMoney(event1,user);
                dbh.updateEvents(event1);
                dbh.updateEventsWinners(event1);
                dbh.updateEventsLosers(event1);
                try {
                    updateTable();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        confrimButton1.setOnAction(event -> {
            Event event1=Table.getSelectionModel().getSelectedItem();
            if(event1==null)
            {
                error.setVisible(true);
            }
            else {
                DatabaseHandler dbh=new DatabaseHandler();
                User user = new User();
                try {
                    user=dbh.findUserById(event1.getUserId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                dbh.superUpdateMoney(event1,user);
                dbh.updateEvents(event1);
                dbh.updateEventsWinners(event1);
                dbh.updateEventsLosers(event1);
                try {
                    updateTable();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/admin.fxml");
        });




    }
    public void updateTable() throws SQLException {
        eventList.clear();
        DatabaseHandler dbh=new DatabaseHandler();
        ResultSet rs=dbh.getActiveEvents();
        while (rs.next()) {
            int betId=rs.getInt("bet_id");
            int team1=rs.getInt("team_1");
            int team2=rs.getInt("team_2");
            double sum=rs.getDouble("sum");
            int userID=rs.getInt("user_id");
            int isWin=rs.getInt("isWin");
            int id=rs.getInt("idEvent");
            Event event=new Event(betId,team1,team2,userID,isWin,sum,id);
            ResultSet res1=dbh.getBet(event);
            res1.next();
            if (event.getTeam1()==1) {
                event.setTeam(res1.getString("team_1"));
                event.setKev(res1.getDouble("kev_1"));
                event.setSecondTeam(res1.getString("team_2"));
                event.setWinningTeam(1);
            }
            if (event.getTeam2()==1) {
                event.setTeam(res1.getString("team_2"));
                event.setKev(res1.getDouble("kev_2"));
                event.setSecondTeam(res1.getString("team_1"));
                event.setWinningTeam(2);

            }
            event.setSport(res1.getString("sport"));

            eventList.add(event);
        }
        sportField.setCellValueFactory(new PropertyValueFactory<>("sport"));
        teamField.setCellValueFactory(new PropertyValueFactory<>("team"));
        sumField.setCellValueFactory(new PropertyValueFactory<>("sum"));
        kevField.setCellValueFactory(new PropertyValueFactory<>("kev"));
        secondTeamfield.setCellValueFactory(new PropertyValueFactory<>("secondTeam"));
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        betId.setCellValueFactory(new PropertyValueFactory<>("betId"));

        Table.setItems(eventList);

    }



}
