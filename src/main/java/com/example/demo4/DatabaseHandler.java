package com.example.demo4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
        String connectionString = "jbdc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);


        return dbConnection;
    }
public void signUp(String name, String surname,String password,String login )
{
String insert="INSERT INTO"+Constants.USER_TABLE+"("+Constants.USER_LOGIN+","+Constants.USER_PASSWORD+","+
        Constants.USER_NAME+","+Constants.USER_SURNAME+")"+"VALUES(?,?,?,?)";

    try {
        PreparedStatement pr=getDbConnection().prepareStatement(insert);
        pr.setString(1, login);
        pr.setString(2, password);
        pr.setString(3, name);
        pr.setString(4, surname);
        pr.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
}
}
