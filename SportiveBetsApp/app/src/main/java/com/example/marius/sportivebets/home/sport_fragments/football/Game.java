package com.example.marius.sportivebets.home.sport_fragments.football;

public class Game {

    private String firstTeam;
    private String secondTeam;
    private double cotaWinFirstTeam;
    private double cotaWinSecondTeam;
    private double cotaDrawn;

    public Game(String firstTeam, String secondTeam, double cotaWinFirstTeam, double cotaWinSecondTeam, double cotaDrawn) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.cotaWinFirstTeam = cotaWinFirstTeam;
        this.cotaWinSecondTeam = cotaWinSecondTeam;
        this.cotaDrawn = cotaDrawn;
    }

    public Game() {
    }


    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public double getCotaWinFirstTeam() {
        return cotaWinFirstTeam;
    }

    public void setCotaWinFirstTeam(double cotaWinFirstTeam) {
        this.cotaWinFirstTeam = cotaWinFirstTeam;
    }

    public double getCotaWinSecondTeam() {
        return cotaWinSecondTeam;
    }

    public void setCotaWinSecondTeam(double cotaWinSecondTeam) {
        this.cotaWinSecondTeam = cotaWinSecondTeam;
    }

    public double getCotaDrawn() {
        return cotaDrawn;
    }

    public void setCotaDrawn(double cotaDrawn) {
        this.cotaDrawn = cotaDrawn;
    }
}
