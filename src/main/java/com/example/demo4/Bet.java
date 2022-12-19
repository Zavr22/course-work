package com.example.demo4;

public class Bet {
    private String team1,team2,sport;
    private double kev1,kev2;
    private int betId;

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public Bet(String team1, String team2, double kev1, double kev2,String sport,int id) {
        this.team1 = team1;
        this.team2 = team2;
        this.kev1 = kev1;
        this.kev2 = kev2;
        this.sport=sport;
        this.betId=id;
    }
    public Bet(String team1, String team2, double kev1, double kev2,String sport) {
        this.team1 = team1;
        this.team2 = team2;
        this.kev1 = kev1;
        this.kev2 = kev2;
        this.sport=sport;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public double getKev1() {
        return kev1;
    }

    public void setKev1(double kev1) {
        this.kev1 = kev1;
    }

    public double getKev2() {
        return kev2;
    }

    public void setKev2(double kev2) {
        this.kev2 = kev2;
    }
}
