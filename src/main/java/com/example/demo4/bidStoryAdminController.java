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

import static com.example.demo4.HelloController.selectedUser;
import static com.example.demo4.metods.oppenNewScene;

public class bidStoryAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Event> Table;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField error;

    @FXML
    private Button infoButton;

    @FXML
    private TableColumn<Event, Double> kevField;

    @FXML
    private TableColumn<Event, String> resultField;

    @FXML
    private TableColumn<Event, Double> sumField;

    @FXML
    private TableColumn<Event, String> teamField;

    @FXML
    private TableColumn<Event, String> login;
    ObservableList<Event> eventList= FXCollections.observableArrayList();
    @FXML
    void initialize() throws SQLException {
        updateTable();
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/admin.fxml");
        });


    }
    public void updateTable() throws SQLException {
        eventList.clear();
        DatabaseHandler dbh=new DatabaseHandler();
        ResultSet rs=dbh.getAllEvents();
        while (rs.next()) {
            int betId=rs.getInt("bet_id");
            int team1=rs.getInt("team_1");
            int team2=rs.getInt("team_2");
            double sum=rs.getDouble("sum");
            int userID=rs.getInt("user_id");
            int isWin=rs.getInt("isWin");
            Event event=new Event(betId,team1,team2,userID,isWin,sum);
            if(event.getIsWin()==0)
            {
                event.setResult("Ожидайте подтверждения");
            }
            if(event.getIsWin()==1)
            {
                event.setResult("Победа");
            }
            if(event.getIsWin()==2)
            {
                event.setResult("Проигрыш");
            }
            ResultSet res1=dbh.getBet(event);
            res1.next();
            if (event.getTeam1()==1) {
                event.setTeam(res1.getString("team_1"));
                event.setKev(res1.getDouble("kev_1"));
            }
            if (event.getTeam2()==1) {
                event.setTeam(res1.getString("team_2"));
                event.setKev(res1.getDouble("kev_2"));
            }
            User user = new User();
            user=dbh.findUserById(event.getUserId());
            event.setLogin(user.getLogin());

            eventList.add(event);
        }

        teamField.setCellValueFactory(new PropertyValueFactory<>("team"));
        sumField.setCellValueFactory(new PropertyValueFactory<>("sum"));
        kevField.setCellValueFactory(new PropertyValueFactory<>("kev"));
        resultField.setCellValueFactory(new PropertyValueFactory<>("result"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        Table.setItems(eventList);

    }



}
