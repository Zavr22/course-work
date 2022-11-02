package com.example.demo4;

public class User {
  static   int userID;
    private String name,surName,login,password;

    public User( String name, String surName, String login, String password) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
    }
    public User(){
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return this.name;
    }

    public String getSurName() {
        return this.surName;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
