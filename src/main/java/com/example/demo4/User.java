package com.example.demo4;

public class User {
  private   int userID,isApprove;
    private String name,surName,login,password;
    private Double money;

    public User(int userID,  String name, String surName, String login, String password, Double money) {
        this.userID = userID;
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.money = money;
    }

    public User(Double money) {
        this.money = money;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User(String name, String surName, String login, String password, int isApprove) {
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.isApprove=isApprove;
    }
    public User(){
    }

    public User(int isApprove, String name, String surName, String login) {
        this.isApprove = isApprove;
        this.name = name;
        this.surName = surName;
        this.login = login;
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

    public int getIsApprove() {
        return isApprove;
    }

    public void setApproved(int approved) {
        this.isApprove = approved;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
