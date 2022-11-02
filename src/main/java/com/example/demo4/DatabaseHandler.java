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
        Constants.USER_NAME+","+Constants.USER_SURNAME+")"+"VALUES(?,?,?,?)";

    try {
        PreparedStatement pr=getDbConnection().prepareStatement(insert);
        pr.setString(1, user.getLogin());
        pr.setString(2, user.getPassword());
        pr.setString(3, user.getName());
        pr.setString(4, user.getSurName());
        pr.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
public ResultSet getUser(User user){
        ResultSet rs=null;
        String select = "SELECT * FROM "+Constants.USER_TABLE+" WHERE "+ Constants.USER_LOGIN+
                "=? AND "+Constants.USER_PASSWORD+"=?";
    try {
        PreparedStatement pr=getDbConnection().prepareStatement(select);
        pr.setString(1, user.getLogin());
        pr.setString(2, user.getPassword());
        rs=pr.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    return rs;
}
}
