package com.example.marius.sportivebets.home.sport_fragments.football;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.marius.sportivebets.api.models.Game;
import com.example.marius.sportivebets.databinding.FootballLeaguesLayoutBinding;
import com.example.marius.sportivebets.databinding.ListItemGamesBinding;
import com.example.marius.sportivebets.home.sport_fragments.football.models.GameModel;
import com.example.marius.sportivebets.home.sport_fragments.football.models.LeagueTitleModel;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

public class FootbalAdapter extends ExpandableRecyclerViewAdapter<FootbalAdapter.FootballViewHolder, FootbalAdapter.GamesHolder> {

    private LayoutInflater layoutInflater;
    private LayoutInflater layoutInflaterChild;

    public FootbalAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public FootballViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        FootballLeaguesLayoutBinding footballLeaguesLayoutBinding = FootballLeaguesLayoutBinding.inflate(layoutInflater, parent, false);
        return new FootballViewHolder(footballLeaguesLayoutBinding);
    }

    @Override
    public GamesHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        if(layoutInflaterChild==null)
        {
            layoutInflaterChild=LayoutInflater.from(parent.getContext());
        }
        ListItemGamesBinding listItemGamesBinding=ListItemGamesBinding.inflate(layoutInflaterChild,parent,false);
        return new GamesHolder(listItemGamesBinding);
    }

    @Override
    public void onBindChildViewHolder(GamesHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

       
        holder.bind(new GameModel((Game) group.getItems().get(childIndex)));
    }

    @Override
    public void onBindGroupViewHolder(FootballViewHolder holder, int flatPosition, ExpandableGroup group) {

        holder.bind(new LeagueTitleModel(group.getTitle()));

    }


    public static class FootballViewHolder extends GroupViewHolder {

        private FootballLeaguesLayoutBinding footballLeaguesLayoutBinding;


        private FootballViewHolder(FootballLeaguesLayoutBinding footballLeaguesLayoutBinding) {
            super(footballLeaguesLayoutBinding.getRoot());
            this.footballLeaguesLayoutBinding = footballLeaguesLayoutBinding;
        }


        public void bind(LeagueTitleModel leagueTitleModel) {
            footballLeaguesLayoutBinding.setLeagueTitleModel(leagueTitleModel);

        }

        public FootballLeaguesLayoutBinding getFootballLeaguesLayoutBinding() {
            return footballLeaguesLayoutBinding;
        }
    }

    public static class GamesHolder extends ChildViewHolder {

        private ListItemGamesBinding listItemGamesBinding;

        public GamesHolder(ListItemGamesBinding listItemGamesBinding) {
            super(listItemGamesBinding.getRoot());
            this.listItemGamesBinding = listItemGamesBinding;

        }


        public void bind(GameModel gameModel) {
            listItemGamesBinding.setGameModel(gameModel);

        }

    }

}


