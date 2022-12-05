package com.example.demo4;
import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);


        return dbConnection;
    }
public void signUp(User user )
{
String insert="INSERT INTO "+Constants.USER_TABLE+"("+Constants.USER_LOGIN+","+Constants.USER_PASSWORD+","+
        Constants.USER_NAME+","+Constants.USER_SURNAME+",isApprove)"+"VALUES(?,?,?,?,?)";

    try {
        PreparedStatement pr=getDbConnection().prepareStatement(insert);
        pr.setString(1, user.getLogin());
        pr.setString(2, user.getPassword());
        pr.setString(3, user.getName());
        pr.setString(4, user.getSurName());
        pr.setInt(5, user.getIsApprove());
        pr.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
public ResultSet getUser(User user){
        ResultSet rs=null;
        String login=user.getLogin();
        String password=user.getPassword();
        String select = "SELECT * FROM " +Constants.USER_TABLE+ " WHERE " + Constants.USER_LOGIN+
                "=" +"'"+login+"'" + " AND "+Constants.USER_PASSWORD+ "=" + "'"+password+"'";
    try {
        PreparedStatement pr=getDbConnection().prepareStatement(select);
        rs=pr.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    return rs;
}
    public ResultSet getUserLogin(User user){
        ResultSet rs=null;
        String select = "SELECT * FROM "+Constants.USER_TABLE+" WHERE "+ Constants.USER_LOGIN+
                "=?";
        try {
            PreparedStatement pr=getDbConnection().prepareStatement(select);
            pr.setString(1, user.getLogin());
            rs=pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ResultSet getUsers(){
        ResultSet rs=null;
        String select = "SELECT * FROM "+Constants.USER_TABLE;
        try {
            PreparedStatement pr=getDbConnection().prepareStatement(select);
            rs=pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
   public void updateApprove(User user){
        String insert="UPDATE "+ Constants.USER_TABLE+" SET"+" isApprove='1' WHERE "+Constants.USER_LOGIN+"=?";

        try {
            PreparedStatement pr=getDbConnection().prepareStatement(insert);
            pr.setString(1, user.getLogin());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void createBet(Bet bet )
    {
        String insert="INSERT INTO "+" bet "+"("+"team_1, team_2, kev_1, kev_2)"  + "VALUES (?,?,?,?)";

        try {
            PreparedStatement pr=getDbConnection().prepareStatement(insert);
            pr.setString(1, bet.getTeam1());
            pr.setString(2, bet.getTeam1());
            pr.setDouble(3, bet.getKev1());
            pr.setDouble(4, bet.getKev2());

            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
