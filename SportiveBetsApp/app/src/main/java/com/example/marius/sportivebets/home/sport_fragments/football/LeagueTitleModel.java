package com.example.marius.sportivebets.home.sport_fragments.football;

public class LeagueTitleModel {

    public String title;

    public LeagueTitleModel(LeagueTitle leagueTitle)
    {
        this.title=leagueTitle.getTitle();
    }

    public LeagueTitleModel(String title)
    {
        this.title=title;
    }
}
