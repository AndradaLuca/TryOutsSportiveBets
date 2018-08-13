package com.example.marius.sportivebets.home.sport_fragments.football;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.api.models.Game;
import com.example.marius.sportivebets.databinding.FootballLeaguesLayoutBinding;
import com.example.marius.sportivebets.databinding.ListItemGamesBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.betTicket.BetTicketItem;
import com.example.marius.sportivebets.home.bottomNavFragments.betTicket.BetTicketItemsModel;
import com.example.marius.sportivebets.home.sport_fragments.football.models.GameModel;
import com.example.marius.sportivebets.home.sport_fragments.football.models.LeagueTitleModel;
import com.example.marius.sportivebets.utils.Constants;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.CYAN;
import static com.example.marius.sportivebets.R.*;
import static com.example.marius.sportivebets.R.color.*;
import static com.example.marius.sportivebets.utils.Constants.betTicketItems;

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

    public static class GamesHolder extends ChildViewHolder implements IFootbalBet {


        public   static List<BetTicketItemsModel> betTicketItems = new ArrayList<>() ;

        private  ListItemGamesBinding listItemGamesBinding;



        public GamesHolder(ListItemGamesBinding listItemGamesBinding) {
            super(listItemGamesBinding.getRoot());
            this.listItemGamesBinding = listItemGamesBinding;


        }





        public void bind(GameModel gameModel) {
            listItemGamesBinding.setGameModel(gameModel);
            listItemGamesBinding.setIFootbalBet(this);
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onBetButtonClick() {
            String tip=null;
            double cota=0.0;
            String betName=null;
            if (listItemGamesBinding.buttonWinFirstTeam.isPressed()) {
                tip = listItemGamesBinding.buttonWinFirstTeam.getText().toString();
                String[] s = listItemGamesBinding.buttonWinFirstTeam.getText().toString().split("\n");
                cota = Double.parseDouble(s[1]);
                betName = listItemGamesBinding.listGames.getText().toString();
                
            }
            if (listItemGamesBinding.buttonDraw.isPressed()) {
                tip = listItemGamesBinding.buttonDraw.getText().toString();
                String[] s = listItemGamesBinding.buttonDraw.getText().toString().split("\n");
                cota = Double.parseDouble(s[1]);
                betName = listItemGamesBinding.listGames.getText().toString();

            }
            if (listItemGamesBinding.buttonWinSecondTeam.isPressed()) {
                tip = listItemGamesBinding.buttonWinSecondTeam.getText().toString();
                String[] s = listItemGamesBinding.buttonWinSecondTeam.getText().toString().split("\n");
                cota = Double.parseDouble(s[1]);
                betName = listItemGamesBinding.listGames.getText().toString();
            }

            betTicketItems.add(new BetTicketItemsModel(new BetTicketItem(cota, tip, betName)));

            //listItemGamesBinding.buttonWinFirstTeam
        }
    }

}


