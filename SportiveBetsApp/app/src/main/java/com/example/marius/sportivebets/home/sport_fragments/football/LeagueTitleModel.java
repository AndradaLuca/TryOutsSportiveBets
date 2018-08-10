package com.example.marius.sportivebets.home.sport_fragments.football;

public class LeagueTitleModel {

    public String title;

    public LeagueTitleModel(ExpandableLeague expandableLeague)
    {
        this.title= expandableLeague.getTitle();
    }

    public LeagueTitleModel(String title)
    {
        this.title=title;
    }
}
