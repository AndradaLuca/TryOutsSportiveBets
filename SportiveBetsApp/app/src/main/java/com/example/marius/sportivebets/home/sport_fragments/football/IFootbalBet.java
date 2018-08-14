package com.example.marius.sportivebets.home.sport_fragments.football;

public interface IFootbalBet {
    void onWinFirstTeamClick(boolean isChecked);
    void onDrawClick(boolean isChecked);
    void onWinSecoundTeamClick(boolean isChecked);
    void onCancelClick();
}
