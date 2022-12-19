package com.example.demo4;

import java.sql.*;

import static com.example.demo4.HelloController.selectedUser;
import static com.example.demo4.bidMenuController.selectedBet;

public class DatabaseHandler extends com.example.demo4.Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);


        return dbConnection;
    }

    public void signUp(User user) {
        String insert = "INSERT INTO " + Constants.USER_TABLE + "(" + Constants.USER_LOGIN + "," + Constants.USER_PASSWORD + "," +
                Constants.USER_NAME + "," + Constants.USER_SURNAME + ",isApprove,money)" + "VALUES(?,?,?,?,?,0)";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
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

    public ResultSet getUser(User user) {
        ResultSet rs = null;
        String login = user.getLogin();
        String password = user.getPassword();
        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE " + Constants.USER_LOGIN +
                "=" + "'" + login + "'" + " AND " + Constants.USER_PASSWORD + "=" + "'" + password + "'";
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet getUserLogin(User user) {
        ResultSet rs = null;
        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE " + Constants.USER_LOGIN +
                "=?";
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            pr.setString(1, user.getLogin());
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet getUsers() {
        ResultSet rs = null;
        String select = "SELECT * FROM " + Constants.USER_TABLE;
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public void updateApprove(User user) {
        String insert = "UPDATE " + Constants.USER_TABLE + " SET" + " isApprove='1' WHERE " + Constants.USER_LOGIN + "=?";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.setString(1, user.getLogin());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createBet(Bet bet) {
        String insert = "INSERT INTO " + " bet " + "(" + "team_1, team_2, kev_1, kev_2,sport)" + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.setString(1, bet.getTeam1());
            pr.setString(2, bet.getTeam2());
            pr.setDouble(3, bet.getKev1());
            pr.setDouble(4, bet.getKev2());
            pr.setString(5, bet.getSport());

            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getBets() {
        ResultSet rs = null;
        String select = "SELECT * FROM bet ";
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet getBet(Event event) {
        ResultSet rs = null;
        String select = "SELECT * FROM bet where id=" + event.getBetId();
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public void makeIvent(double Sum, int team) {
        String insert = "";
        if (team == 1) {
            insert = "INSERT INTO Event " + "(bet_id,team_1,team_2,is_active,sum,user_id,isWin)" + "VALUES(?,1,0,1,?,?,0)";
        } else {
            insert = "INSERT INTO Event " + "(bet_id,team_1,team_2,is_active,sum,user_id,isWin)" + "VALUES(?,0,1,1,?,?,0)";
        }

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.setInt(1, selectedBet.getBetId());
            pr.setDouble(2, Sum);
            pr.setInt(3, selectedUser.getUserID());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMoney(User user, double cash) {
        Double newMoney = user.getMoney() - cash;
        String insert = "UPDATE " + Constants.USER_TABLE + " SET" + " money=" + newMoney
                + " WHERE " + Constants.USER_LOGIN + "=?";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.setString(1, user.getLogin());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateMoneyIncome(User user, double cash) {
        Double newMoney = user.getMoney() + cash;
        String insert = "UPDATE " + Constants.USER_TABLE + " SET" + " money=" + newMoney
                + " WHERE " + Constants.USER_LOGIN + "=?";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.setString(1, user.getLogin());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllEvents() {
        ResultSet rs = null;
        String select = "SELECT * FROM Event ";
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet getEvents(User user) {
        ResultSet rs = null;
        String select = "SELECT * FROM Event WHERE user_id=" + user.getUserID();
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet getActiveEvents() {
        ResultSet rs = null;
        String select = "SELECT * FROM Event WHERE is_active=1 ";
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public void superUpdateMoney(Event event, User user) {

        Double newMoney = event.getSum() * event.getKev() + user.getMoney();


        String insert = "UPDATE " + Constants.USER_TABLE + " SET" + " money=money+" + newMoney
                + " WHERE idUser IN ( SELECT user_id FROM Event WHERE bet_id=" + event.getBetId() + " AND team_" +
                event.getWinningTeam() + "=1" + ")";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public User findUserById(int Id) throws SQLException {
        ResultSet rs = null;
        String select = "SELECT * FROM " + Constants.USER_TABLE + " WHERE idUser=" + Id;
        try {
            PreparedStatement pr = getDbConnection().prepareStatement(select);
            rs = pr.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        rs.next();
        User money = new User(rs.getDouble("money"));
        money.setLogin(rs.getString("login"));
        money.setUserID(Id);

        return money;
    }

    public void updateEvents(Event event) {
        String insert = "UPDATE Event" + " SET" + " is_active=0"
                + " WHERE bet_id= " + event.getBetId();

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEventsWinners(Event event) {

        String insert = "UPDATE Event" + " SET" + " isWin=1"
                + " WHERE bet_id= " + event.getBetId() + " AND team_" + event.getWinningTeam() + "=1";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateEventsLosers(Event event) {
        String insert = "UPDATE Event" + " SET" + " isWin=2"
                + " WHERE bet_id= " + event.getBetId() + " AND team_" + event.getWinningTeam() + "=0";

        try {
            PreparedStatement pr = getDbConnection().prepareStatement(insert);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}