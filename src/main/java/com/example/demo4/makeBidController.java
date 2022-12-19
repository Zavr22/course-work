package com.example.demo4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static com.example.demo4.HelloController.selectedUser;
import static com.example.demo4.bidMenuController.selectedBet;
import static com.example.demo4.metods.oppenNewScene;

public class makeBidController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox chekBox2;

    @FXML
    private TextField errortext;

    @FXML
    private Button make;

    @FXML
    private TextField moneyField;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    void initialize() {
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            oppenNewScene("/com/example/demo4/bidMenuUser.fxml");

        });
        checkBox1.setOnAction(event -> {
            chekBox2.setSelected(false);
        });

        chekBox2.setOnAction(event -> {
            checkBox1.setSelected(false);
        });
        text1.setText("Команда 1:"+selectedBet.getTeam1()+" Коэфицент на команду 1:"+selectedBet.getKev1());
        text2.setText("Команда 2:"+selectedBet.getTeam2()+" Коэфицент на команду 2:"+selectedBet.getKev2());
        make.setOnAction(event -> {
            errortext.setVisible(false);
            if (!chekBox2.isSelected() && !checkBox1.isSelected())
            {
                errortext.setText("Выберите ставку");
                errortext.setVisible(true);
            }
            else {
                double sum = Double.parseDouble(moneyField.getText());
                if (sum > selectedUser.getMoney()) {
                    errortext.setText("У вас на счету " + selectedUser.getMoney() + " выберите допустимое количество средств");
                    errortext.setVisible(true);
                } else {
                    if (checkBox1.isSelected()) {
                        DatabaseHandler dbh = new DatabaseHandler();
                        DatabaseHandler dbh1 = new DatabaseHandler();
                        dbh.makeIvent(sum, 1);
                        dbh1.updateMoney(selectedUser, sum);
                        selectedUser.setMoney(selectedUser.getMoney() - sum);
                        make.getScene().getWindow().hide();
                        oppenNewScene("/com/example/demo4/UserMenu.fxml");
                    }
                    if (chekBox2.isSelected()) {
                        DatabaseHandler dbh = new DatabaseHandler();
                        DatabaseHandler dbh1 = new DatabaseHandler();
                        dbh.makeIvent(sum, 2);
                        dbh1.updateMoney(selectedUser, sum);
                        selectedUser.setMoney(selectedUser.getMoney() - sum);
                        make.getScene().getWindow().hide();
                        oppenNewScene("/com/example/demo4/UserMenu.fxml");
                    }
                }
            }
        });


    }

}
