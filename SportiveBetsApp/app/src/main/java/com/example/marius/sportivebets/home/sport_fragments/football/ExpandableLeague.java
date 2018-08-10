package com.example.marius.sportivebets.home.sport_fragments.football;

import com.example.marius.sportivebets.api.models.Game;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ExpandableLeague extends ExpandableGroup {
    public ExpandableLeague(String title, List<Game> items) {
        super(title, items);
    }
}
