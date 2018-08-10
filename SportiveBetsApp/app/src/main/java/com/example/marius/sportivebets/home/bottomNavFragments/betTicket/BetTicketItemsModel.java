package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class BetTicketItemsModel {

    private String odd;
    private String bet;
    private String event;
    private String category;
    ImageButton closeImageButton;
    CheckBox checkBox;

    public BetTicketItemsModel(BetTicketItem betTicketItem){
        this.bet = betTicketItem.getBet();
        this.odd = betTicketItem.getOdd();
        this.event = betTicketItem.getEvent();
        this.category = betTicketItem.getCategory();
        this.closeImageButton = betTicketItem.getCloseImageButton();
        this.checkBox = betTicketItem.getCheckBox();
    }
    public String getTitle(){
        return bet+" @ "+odd;
    }
}
