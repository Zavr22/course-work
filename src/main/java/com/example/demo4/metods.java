package com.example.demo4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static boolean checkUser(User user) throws SQLException {
        DatabaseHandler dbH = new DatabaseHandler();
        ResultSet res= dbH.getUser(user);
        int counter = 0;
        while (true) {
            try {

                if (!res.next()) break;


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if (counter == 1 ) return true;
        else return false;
    }

        public static boolean checkUserLogin(User user)
        {
            DatabaseHandler dbH=new DatabaseHandler();
            ResultSet res=dbH.getUserLogin(user);
            int counter=0;
            while (true){
                try {
                    if (!res.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
            if (counter ==1) return true;
            else return false;
        }
    public static boolean checkApprove(User user) throws SQLException {
        DatabaseHandler dbHA = new DatabaseHandler();
        ResultSet res1 = dbHA.getUser(user);
        res1.next();
       int approve=res1.getInt("isApprove");
        if( approve!=0) return true;
        else return false;
    }

}
