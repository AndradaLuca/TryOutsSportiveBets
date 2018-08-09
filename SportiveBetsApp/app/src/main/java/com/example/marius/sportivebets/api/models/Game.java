package com.example.marius.sportivebets.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("first_team")
    @Expose
    private String firstTeam;

    @SerializedName("second_team")
    @Expose
    private String secondTeam;

    @SerializedName("cota_win_first_team")
    @Expose
    private Double cotaWinFirstTeam;

    @SerializedName("cota_win_second_team")
    @Expose
    private Double cotaWinSecondTeam;

    @SerializedName("cota_draw")
    @Expose
    private Double cotaDraw;


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

    public Double getCotaWinFirstTeam() {
        return cotaWinFirstTeam;
    }

    public void setCotaWinFirstTeam(Double cotaWinFirstTeam) {
        this.cotaWinFirstTeam = cotaWinFirstTeam;
    }

    public Double getCotaWinSecondTeam() {
        return cotaWinSecondTeam;
    }

    public void setCotaWinSecondTeam(Double cotaWinSecondTeam) {
        this.cotaWinSecondTeam = cotaWinSecondTeam;
    }

    public Double getCotaDraw() {
        return cotaDraw;
    }

    public void setCotaDraw(Double cotaDraw) {
        this.cotaDraw = cotaDraw;
    }

}
