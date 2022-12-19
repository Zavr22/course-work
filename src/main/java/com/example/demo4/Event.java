package com.example.demo4;

public class Event {
    private int betId,team1,team2,userId,isWin,eventId,winningTeam;
   private Double sum,kev;
    private String team,result,secondTeam,sport,login;

    public Double getKev() {
        return kev;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSport() {
        return sport;
    }

    public int getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(int winningTeam) {
        this.winningTeam = winningTeam;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public void setKev(Double kev) {
        this.kev = kev;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Event(int betId, int team1, int team2, int userId, int isWin, Double sum) {
        this.betId = betId;
        this.team1 = team1;
        this.team2 = team2;
        this.userId = userId;
        this.isWin = isWin;
        this.sum = sum;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event(int betId, int team1, int team2, int userId, int isWin, Double sum, int id) {
        this.betId = betId;
        this.team1 = team1;
        this.team2 = team2;
        this.userId = userId;
        this.isWin = isWin;
        this.sum = sum;
        this.eventId=id;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getTeam1() {
        return team1;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public int getTeam2() {
        return team2;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
