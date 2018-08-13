package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class BetTicketItem {
    private double cota;
    private String tip;
    private String betName;


    public BetTicketItem() {
    }

    public BetTicketItem(double cota, String tip, String betName) {
        this.cota = cota;
        this.tip = tip;
        this.betName = betName;
    }

    public double getCota() {
        return cota;
    }

    public void setCota(double cota) {
        this.cota = cota;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getBetName() {
        return betName;
    }

    public void setBetName(String betName) {
        this.betName = betName;
    }
}
