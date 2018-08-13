package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class BetTicketItemsModel {

    private double cota;
    private String tip;
    private String betName;


    public BetTicketItemsModel(BetTicketItem betTicketItem) {
        this.cota = betTicketItem.getCota();
        this.tip = betTicketItem.getTip();
        betName = betTicketItem.getBetName();
    }

    public String getTitle(){
        return tip;
    }
    public String getBetName(){
        return betName;
    }
    public double getCota(){
        return cota;
    }
}
