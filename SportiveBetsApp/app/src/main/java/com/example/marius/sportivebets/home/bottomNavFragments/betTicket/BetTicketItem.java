package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.widget.CheckBox;
import android.widget.ImageButton;

public class BetTicketItem {
    private String odd;
    private String bet;
    private String event;
    private String category;
    ImageButton closeImageButton;
    CheckBox checkBox;

    public BetTicketItem() {
    }

    public BetTicketItem(String odd, String bet, String event, String category) {
        this.odd = odd;
        this.bet = bet;
        this.event = event;
        this.category = category;
    }

    // Getters

    public String getOdd() {
        return odd;
    }

    public String getBet() {
        return bet;
    }

    public String getEvent() {
        return event;
    }

    public String getCategory() {
        return category;
    }

    public ImageButton getCloseImageButton() {
        return closeImageButton;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    // Setters


    public void setOdd(String odd) {
        this.odd = odd;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCloseImageButton(ImageButton closeImageButton) {
        this.closeImageButton = closeImageButton;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
