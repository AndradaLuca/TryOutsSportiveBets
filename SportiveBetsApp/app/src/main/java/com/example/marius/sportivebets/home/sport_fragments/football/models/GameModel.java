package com.example.marius.sportivebets.home.sport_fragments.football.models;

import com.example.marius.sportivebets.api.models.Game;

public class GameModel {

    public String title;
    public String firstButton;
    public String drawButton;
    public String secondButton;


    public GameModel(Game game)
    {

        this.title=game.getFirstTeam()+" VS "+game.getSecondTeam();
        this.firstButton=game.getFirstTeam()+"\n"+ game.getCotaWinFirstTeam();
        this.drawButton="Draw"+"\n"+ game.getCotaDraw();
        this.secondButton=game.getSecondTeam()+"\n"+game.getCotaWinSecondTeam();

    }

}
