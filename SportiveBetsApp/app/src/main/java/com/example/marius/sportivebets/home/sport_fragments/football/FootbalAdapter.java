package com.example.marius.sportivebets.home.sport_fragments.football;

import android.annotation.SuppressLint;
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
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.example.marius.sportivebets.R.color;
import static com.example.marius.sportivebets.R.id;

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


        public static List<BetTicketItemsModel> betTicketItems = new ArrayList<>() ;
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
        public void onWinFirstTeamClick(boolean isChecked) {
          betTicketToggler(R.id.buttonWinFirstTeam, isChecked);
          if (isChecked){
              listItemGamesBinding.buttonWinFirstTeam.setBackgroundResource(color.colorPrimary);
          }else {
              listItemGamesBinding.buttonWinFirstTeam.setBackgroundResource(android.R.drawable.btn_default);
          }
        }

        @Override
        public void onDrawClick(boolean isChecked) {
            betTicketToggler(R.id.buttonDraw, isChecked);
            if (isChecked){
                listItemGamesBinding.buttonDraw.setBackgroundResource(color.colorPrimary);
            }else {
                listItemGamesBinding.buttonDraw.setBackgroundResource(android.R.drawable.btn_default);
            }
        }

        @Override
        public void onWinSecoundTeamClick(boolean isChecked) {
            betTicketToggler(id.buttonWinSecondTeam, isChecked);
            if (isChecked){
                listItemGamesBinding.buttonWinSecondTeam.setBackgroundResource(color.colorPrimary);
            }else {
                listItemGamesBinding.buttonWinSecondTeam.setBackgroundResource(android.R.drawable.btn_default);
            }
        }

        private void betTicketToggler(int buttonId, boolean isButtonClicked) {

            String tip=null;
            double cota;
            String betName;
            String[] s = new String[0];

            switch (buttonId) {
                case R.id.buttonWinFirstTeam:
                    tip = listItemGamesBinding.buttonWinFirstTeam.getText().toString();
                    s = listItemGamesBinding.buttonWinFirstTeam.getText().toString().split("\n");
                    break;
                case R.id.buttonDraw:
                    tip = listItemGamesBinding.buttonDraw.getText().toString();
                    s = listItemGamesBinding.buttonDraw.getText().toString().split("\n");
                    break;
                case id.buttonWinSecondTeam:
                    tip = listItemGamesBinding.buttonWinSecondTeam.getText().toString();
                    s = listItemGamesBinding.buttonWinSecondTeam.getText().toString().split("\n");
                    break;
            }

            cota = Double.parseDouble(s[1]);
            betName = listItemGamesBinding.listGames.getText().toString();

            BetTicketItemsModel betObject = new BetTicketItemsModel(new BetTicketItem(cota, tip, betName));



            if(isButtonClicked) {
                if (!betTicketItems.contains(betObject)){
                    betTicketItems.add(betObject);
                }
                //set background blue
                //add item in list
            } else {
                betTicketItems.remove(betObject);
                //set background default
                //remove from list
            }

        }


        @Override
        public void onCancelClick() {

        }
    }

}


